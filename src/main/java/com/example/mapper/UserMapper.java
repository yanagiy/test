/**
 *
 */
package com.example.mapper;

/**
 * @author tayanagiya
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<List<User>> {
    public List<User> mapRow(ResultSet result, int rowNum)
            throws SQLException {
        // 初期化
        List<User> list = new ArrayList<>();

        User test_user = new User();
        test_user.setId(result.getInt("id"));
        test_user.setAge(result.getInt("age"));
        test_user.setName(result.getString("name"));
        test_user.setAddress(result.getString("address"));
        test_user.setTell(result.getString("tell"));
        test_user.setMail(result.getString("mail"));
        list.add(test_user);
        // result.next=次の行
        while (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setAge(result.getInt("age"));
            user.setName(result.getString("name"));
            user.setAddress(result.getString("address"));
            user.setTell(result.getString("tell"));
            user.setMail(result.getString("mail"));
            list.add(user);
        }
        return list;
    }
}
