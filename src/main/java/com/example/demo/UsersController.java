package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller		// コントローラー宣言
public class UsersController {
    @RequestMapping("/top")		// URL指定
    public String top(Model model) {
        return "users/top";
    }

    @RequestMapping("/input")
    public String input() {
        return "users/input";
    }

    @RequestMapping("/confirmation")
    public String confirmation() {
        return "users/confirmation";
    }

    @RequestMapping("/details")
    public String details() {
        return "users/idetails";
    }
}