package com.board.configuration;

import com.board.security.JwtAuthenticationFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http 시큐리티 필터
        http.cors().and().csrf().disable().httpBasic().disable().httpBasic().disable().sessionManagement() // 세션 기반은
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers("/", "/auth/**").permitAll().anyRequest().authenticated();

        // 매 요청마다 CorsFilter를 실행 후에 jwtAuthenticationFilter 실행
        http.addFilterAfter(
                jwtAuthenticationFilter, CorsFilter.class
        );
    }


}
