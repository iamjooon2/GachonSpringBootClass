package com.board.service;

import com.board.domain.UserDTO;

public interface UserService {
    public boolean signUpUser(UserDTO params);
    public int updateUserNickname(long idx);
    public boolean checkUserNameExists(UserDTO params);
    public boolean isPasswordTrue(UserDTO params);

    public long selectUserIdx(UserDTO params);
}
