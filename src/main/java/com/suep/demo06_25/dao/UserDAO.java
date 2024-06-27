package com.suep.demo06_25.dao;

import com.suep.demo06_25.model.User;

import java.sql.SQLException;

public interface UserDAO {
    // 用户注册
    void registerUser(User user) throws SQLException;
}
