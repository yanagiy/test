package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersTopController{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping(path ="/top", method = RequestMethod.GET)
    String top(Model model) {
        List<Users> list = jdbcTemplate.queryForObject("select * from users", new Mapper());
        model.addAttribute("list", list);
        return "users/top";
    }


    @RequestMapping(path ="/input", method = RequestMethod.GET)
    String input() {
        return "users/input";
    }
}