package com.board.service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 사용자와 관련된 모든 비즈니스 로직을 처리하는 UserServiceImpl 클래스
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean signUpUser(UserDTO params){
        return userMapper.signUpUser(params);
    }

    @Override
    public boolean checkUserNameExists(UserDTO params){
        return userMapper.checkUserNameExists(params);
    }

    @Override
    public boolean isPasswordTrue(UserDTO params){
        return userMapper.isPasswordTrue(params);
    }



}
