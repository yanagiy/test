package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    static final String URL = "jdbc:mysql://localhost:3306/user?serverTimezone=JST";
    static final String USERNAME = "root";
    static final String PASSWORD = "yanagiyaiii3";

    @RequestMapping("/top")
    public String top(Model model) {
        //DB(テーブル取得) 書き方次第？？
        String sql = "SELECT * FROM users;";

        try(Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(sql);){

            ResultSet result = statement.executeQuery();   //SQL文_実行結果取得。
            while(result.next()) {
                model.addAttribute("result",result);
                System.out.println(result.getInt("id"));
                /*System.out.println(result.getInt("age"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("address"));
                System.out.println(result.getInt("tell"));
                System.out.println(result.getString("mail"));*/
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
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
        return "users/details";
    }
}