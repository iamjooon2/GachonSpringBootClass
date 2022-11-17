package com.board.service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 사용자와 관련된 모든 비즈니스 로직을 처리하는 UserServiceImpl 클래스
@Service
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean signUpUser(UserDTO params) {
        params.setPassword(passwordEncoder.encode(params.getPassword()));
        return userMapper.signUpUser(params);
    }

    @Override
    public boolean checkUserNameExists(UserDTO params) {
        return userMapper.checkUserNameExists(params);
    }

    @Override
    public boolean isPasswordTrue(UserDTO params) {
        // 비밀번호 데이터베이스에서 가져온다
        String hashedPassword = userMapper.selectPassword(params);
        // 해쉬시킨 비밀번호와 사용자의 비밀번호가 일치한다면 True 리턴
        if (passwordEncoder.matches(hashedPassword, params.getPassword())) {
            return true;
        }
        // 아니라면 False 리턴
        return false;
    }


}
