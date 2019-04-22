package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mapper.User;
import com.example.mapper.UserMapper;


@Controller
public class UserController{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // URL指定、情報の取得を要求。
    @RequestMapping(path ="/top", method = RequestMethod.GET)
    String top(Model model) {
        // 全件取得
        List<User> list = jdbcTemplate.queryForObject("select * from users", new UserMapper());
        // Viewに値を与える。
        model.addAttribute("list", list);
        return "users/top";
    }

    //@PathVariable "{id}の部分を取得している。"
    @RequestMapping(path = "/top{id}", method = RequestMethod.GET)
    String delete(Model model, @PathVariable("id") int id) {
        jdbcTemplate.update("delete from user where id = ? ", id);
        List<User> list = jdbcTemplate.queryForObject("select * from users", new UserMapper());
        model.addAttribute("list", list);
         return "redirect:/top";
        //return "users/top";
    }

    @RequestMapping(path ="/input", method = RequestMethod.GET)
    String input() {
        return "users/input";
    }
    //@RequestMapping(path ="/details", method = RequestMethod.GET)
    /*String details(Model model/*@PathVariable("id") int id*///) {
       /* List<User> list = jdbcTemplate.queryForObject("select * from users", new UserMapper());
        model.addAttribute("list", list);
        return "users/details";
    }*/

    @RequestMapping(value = "details/{id", method = RequestMethod.GET)
    String details(Model model, @PathVariable("id") int id) {
        //List<User> list = jdbcTemplate.queryForObject("select from user where id",id);
        List<User> list = jdbcTemplate.queryForObject("select * from users", new UserMapper());
        model.addAttribute("list", list);
        return "users/details";
    }
}