package com.board.service;

import com.board.domain.UserDTO;
import com.board.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean logInUser(UserDTO params){
        return checkUserNameExists(params) && isPasswordTrue(params);
    }

}
