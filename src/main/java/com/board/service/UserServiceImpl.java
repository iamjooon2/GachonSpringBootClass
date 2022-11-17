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
    public int updateUserNickname(long idx){
        int a = userMapper.updateUserNickname(idx);
        System.out.println(a);
        return a;
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
    public long selectUserIdx(UserDTO params){
        return userMapper.selectUserIdx(params);
    }


}
