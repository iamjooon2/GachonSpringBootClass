package com.board.controller;

import com.board.constant.Method;
import com.board.domain.UserDTO;
import com.board.service.UserService;
import com.board.util.UiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController extends UiUtils {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/signUp")
    public String signInPage() {
        return "signUp";
    }

    @GetMapping(value = "/index")
    public String loginPage() {
        return "index";
    }

    @GetMapping(value = "/main")
    public String mainPage() {
        return "board/list";
    }


    @PostMapping(value = "/user/login")
    public String loginUser(@ModelAttribute("params") UserDTO params, @RequestParam(value = "idx", required = false) Long idx, Model model) {
        System.out.println(params.toString());

        if (userService.checkUserNameExists(params)
                && userService.checkUserNameExists(params)) {
            return "redirect:/board/list.do";
        }
        return showMessageWithRedirect("존재하지 않는 사용자입니다", "/", Method.GET, null, model);
    }


    @PostMapping(value = "/user/register")
    public String registerUser(@ModelAttribute("params") UserDTO params, @RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (userService.signUpUser(params)){
            return "/";
        }
        return showMessageWithRedirect("에러 발생! 다시 회원가입 해주세용", "/signUp", Method.GET, null, model);
    }



}
