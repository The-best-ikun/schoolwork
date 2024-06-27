package com.suep.demo06_25.untils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLUntil {
    private static final String PROPERTIES_FILE = "database.properties";
    private static String url;
    private static String username;
    private static String password;
    private static String driverClassName;

    static {
//        根据属性文件进行加载
        loadProperties();
    }

    private static void loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = MySQLUntil.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            if (inputStream == null) {
                throw new RuntimeException("Property file " + PROPERTIES_FILE + "路径不正确");
            }

            properties.load(inputStream);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            driverClassName = properties.getProperty("db.driver");

            // 加载数据库驱动
            Class.forName(driverClassName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
//                   后期完善也得弄个日志文件
                    System.out.println(e);
                }
            }
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("连接数据库失败", e);
        }
        return connection;
    }
}
