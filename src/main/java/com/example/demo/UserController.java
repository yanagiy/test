package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    //@PathVariable URLからデータ取得 "{id}の部分を取得している。"
    @RequestMapping(path = "top/delete/{id}", method = RequestMethod.GET)
    String delete(Model model, @PathVariable("id") int id) {
        jdbcTemplate.update("delete from users where id = ? ", id);
        return "redirect:/top";
    }
    //保存用テスト。
    @RequestMapping(path = "/test/{user}", method = RequestMethod.GET)
    String test(Model model, @PathVariable("user") User user) {
        jdbcTemplate.update("insert into users values (?),(?),(?),(?),(?),(?)",
                user.getId(),
                user.getAge(),
                user.getName(),
                user.getAddress(),
                user.getTell(),
                user.getMail());
        return "redirect:/top";
    }

    @RequestMapping(value = "top/detail/{id}", method = RequestMethod.GET)
    String detail(Model model, @PathVariable("id") int id) {
        List<User> list = jdbcTemplate.queryForObject("select * from users where id = ?", new UserMapper(), id);
        model.addAttribute("list", list);
        return "users/detail";
    }

    @RequestMapping(path ="top/input", method = RequestMethod.GET)
    String input(Model model, User user) {
        model.addAttribute("user", user);
        return "users/input";
    }

    // ModelAttribute = 自動でUser(返り値)がModelに入ってくる。
    // BindingResult = @ModelAttributeを付けた引き数の後ろ側でないと反応しない？？、Validation取得用
    @RequestMapping(path="top/input/confirmation", method=RequestMethod.POST )
    String confirmation( Model model, @Validated  User user,BindingResult result) {
        if(result.hasErrors()) {
            return "users/input";
        }
        model.addAttribute("user", user);
        return "users/confirmation";
    }
}