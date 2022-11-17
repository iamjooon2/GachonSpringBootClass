package com.board.service;

import com.board.domain.UserDTO;

// 사용자 서비스의 인터페이스
public interface UserService {
    // 사용자가 회원가입시 사용하는 메서드
    public boolean signUpUser(UserDTO params);
    // 해당 아이디가 존재하는지 확인하는 메서드
    // 회원가입과 로그인시 사용자가 입력한 아이디가 존재하는지 확인하려 사용한다
    public boolean checkUserNameExists(UserDTO params);
    // 사용자가 입력한 비밀번호가 존재하는지 확인하는 메서드
    // 로그인시 입력한 아이디와 입력한 비밀번호가 일치하는지 비교하여 로그인 페이지로 넘겨줄지 결정한다
    public boolean isPasswordTrue(UserDTO params);

}
