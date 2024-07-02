package com.suep.demo06_25.dao;

import com.suep.demo06_25.model.User;

import java.sql.SQLException;

public interface UserDAO {
    // 用户注册
    void registerUser(User user) throws SQLException;

    // 用户登录
    void signInUser(User user) throws SQLException;
    void deleteUserById(int id) throws SQLException;


}
