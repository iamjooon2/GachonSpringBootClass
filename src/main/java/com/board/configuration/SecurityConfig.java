package com.board.configuration;

import com.board.security.JwtAuthenticationFilter;
import com.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    JwtAuthenticationFilter jwtAuthenticationFilter;

    // 권한이 없는 사람은 "/", "login", "signUp" 밖에 접근 불가능함
    // 권한에 따른 기능을 부여해주는 메서드
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                // 누구나 접근 허용
                .antMatchers( "/","/login", "/signUp").permitAll()
                // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
                .anyRequest().authenticated();
        // 매 요청마다 CorsFilter를 실행 후에 jwtAuthenticationFilter 실행
        http.addFilterAfter(
                jwtAuthenticationFilter, CorsFilter.class
        );
    }
}