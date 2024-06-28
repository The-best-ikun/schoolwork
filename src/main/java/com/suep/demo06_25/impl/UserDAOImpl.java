package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.UserDAO;
import com.suep.demo06_25.model.User;
import com.suep.demo06_25.untils.MySQLUntil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// UserDAOImpl实现类
public class UserDAOImpl implements UserDAO {
    @Override
    public boolean signInUser(User user) throws SQLException {
        String sqlStr="select * from user where userID= ? and password= ?";
        Connection connection=MySQLUntil.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sqlStr);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getPassword());

        // 这里添加了获取结果集的代码,判断是否为空
        ResultSet resultSet = preparedStatement.executeQuery();
        // 关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //登录验证成功返回true，否则false
        if(resultSet.isBeforeFirst()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void registerUser(User user) throws SQLException {
        String sqlStr = "insert into user values(?,?,?,?,?)";
        Connection connection = MySQLUntil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStr)) {
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getIdentity());
            preparedStatement.execute();
        } finally {

//            关闭连接
            connection.close();

        }
    }
}