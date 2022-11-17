package com.board.mapper;

import com.board.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

// user 테이블을 조작할 수 있게 미리 정의해둔 Mapper
@Mapper
public interface UserMapper {

    // 사용자 데이터베이스에 값을 집어넣는 메서드
    public boolean signUpUser(UserDTO params);
    // 사용자가 입력한 아이디가 존재하는지 확인하는 메서드
    public boolean checkUserNameExists(UserDTO params);
    // 사용자의 패스워드가 일치하는지 확인하는 메서드
    public boolean isPasswordTrue(UserDTO params);
    // 사용자 테이블에서 해당 유저의 비밀번호를 가져오는 메서드
    public String selectPassword(UserDTO params);

}
