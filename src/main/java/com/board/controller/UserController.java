package com.board.controller;

import com.board.domain.BoardDTO;
import com.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String redirectToLoginPage(@ModelAttribute("params") BoardDTO params, Model model) {
        model.addAttribute("loginPage");

        return "bamboo/login";
    }
}
