/**
 *
 */
package com.example.demo;

/**
 * @author tayanagiya
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper<List<Users>> {
    public List<Users> mapRow(ResultSet result, int rowNum)
            throws SQLException {
        // 初期化＿できてない！！
        List<Users> list = new ArrayList<>();

        Users test_users = new Users();
        test_users.setId(result.getInt("id"));
        test_users.setAge(result.getInt("age"));
        test_users.setName(result.getString("name"));
        test_users.setAddress(result.getString("address"));
        test_users.setTell(result.getInt("tell"));
        test_users.setMail(result.getString("mail"));
        list.add(test_users);
        // result.next=次の行
        while (result.next()) {
            Users users = new Users();
            users.setId(result.getInt("id"));
            users.setAge(result.getInt("age"));
            users.setName(result.getString("name"));
            users.setAddress(result.getString("address"));
            users.setTell(result.getInt("tell"));
            users.setMail(result.getString("mail"));
            list.add(users);
        }
        return list;
    }
}
