package com.board.service;

import com.board.domain.UserDTO;

public interface UserService {
    public boolean signInUser(UserDTO params);
    public boolean logInUser(UserDTO params);
    public boolean checkUserNameExists(UserDTO params);
    public boolean isPasswordTrue(UserDTO params);
}
