package com.board.controller;

import com.board.constant.Method;
import com.board.domain.UserDTO;
import com.board.service.UserService;
import com.board.util.UiUtils;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// 클라이언트로부터 받은 요청 중 사용자와 관련된 요청을 1차적으로 처리하는 컨트롤러
@Controller
public class UserController extends UiUtils {

    // 2-10자의 영문과 숫자와 일부 특수문자(._-)만 입력 가능 정규표현식
    private final String idRegex = "^[a-zA-Z0-9]*$";
    // 영문과 숫자 조합의 8-20자의 비밀번호 정규표현식
    private final String passwordRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$";

    @Autowired
    private UserService userService;

    // 클라이언트로부터 signUp에 대한 요청이 올 시, 지정된 signUp 페이지를 렌더링 해주는 메서드
    @GetMapping(value = "/signUp")
    public String signUpPage() {
        return "signUp";
    }

    // 클라이언트로부터 로그인 페이지 요청이 올 시, 지정된 로그인 페이지를 렌더링 해주는 메서드
    @GetMapping(value = "/index")
    public String loginPage() {
        return "index";
    }

    // 사용자로부터 아이디와 비밀번호를 입력받아 service로 전달한 후, 로그인 결과를 리턴받는 메서드
    @PostMapping(value = "/user/login")
    public String loginUser(
            @ModelAttribute("params") UserDTO params,
            @RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (!userService.checkUserNameExists(params)) {
            // 사용자가 로그인시 입력한 아이디가 존재하지 않으면, 메시지와 함께 로그인페이지를 다시 보여줍니다
            return showMessageWithRedirect("존재하지 않는 사용자입니다", "/", Method.GET, null, model);
        }
        if (!userService.isPasswordTrue(params)) {
            // 사용자가 로그인시 입력한 비밀번호가 해당하는 아이디와 일치하지 않으면, 메시지와 함께 로그인페이지를 다시 보여줍니다
            return showMessageWithRedirect("비밀번호가 일치하지 않습니다.", "/", Method.GET, null, model);
        }

        return showMessageWithRedirect(params.getUsername() + "님, 환영합니다!", "/board/list.do", Method.GET, null,
                model);
    }

    // 사용자로부터 아이디와 비밀번호를 입력받아 service로 전달한 후, 회원가입 결과를 리턴받는 메서드
    @PostMapping(value = "/user/register")
    public String registerUser(@ModelAttribute("params") UserDTO params,
                               @RequestParam(value = "idx", required = false) Long idx, Model model) {

        if (!Pattern.matches(idRegex, params.getUsername())){
            return showMessageWithRedirect("아이디는 2-10자의 영문과 숫자와 일부 특수문자(._-)만 입력해주세요", "/signUp", Method.GET, null, model);
        }
        if (!Pattern.matches(passwordRegex, params.getPassword())){
            return showMessageWithRedirect("비밀번호는 영문과 숫자 조합의 8-20자로 입력해주세요", "/signUp", Method.GET, null, model);
        }
        if (userService.checkUserNameExists(params)) {
            // 사용자가 회원가입시 입력한 아이디가 데이터베이스에 존재하면, 메시지와 함께 회원가입 페이지를 다시 보여줍니다
            return showMessageWithRedirect("이미 존재하는 사용자 이름입니다.", "/signUp", Method.GET, null, model);
        }
        if (!userService.signUpUser(params)) {
            // 회원가입 도중 에러가 생긴다면, 사용자에게 에러가 생겼음을 알리고, 회원가입 페이지를 다시 보여줍니다.
            return showMessageWithRedirect("에러 발생! 다시 회원가입 해주세용", "/signUp", Method.GET, null, model);
        }
        // 성공시 로그인 페이지로 이동합니다.
        return showMessageWithRedirect("회원가입 성공, 로그인 해주세요!", "/", Method.GET, null, model);
    }

}
