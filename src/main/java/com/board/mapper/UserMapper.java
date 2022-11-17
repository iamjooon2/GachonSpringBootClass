package com.board.mapper;

import com.board.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public boolean signUpUser(UserDTO params);
    public boolean checkUserNameExists(UserDTO params);
    public boolean isPasswordTrue(UserDTO params);
    public int updateUserNickname(long idx);

    public long selectUserIdx(UserDTO params);
}
