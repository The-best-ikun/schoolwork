package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.UserDAO;
import com.suep.demo06_25.impl.UserDAOImpl;
import com.suep.demo06_25.model.User;

// UserService类
public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAOImpl();
    }

    public void register(String id, String password1, String password2, String phone, String email) throws Exception {

        // 根据id判断用户身份
        String identity = determineIdentity(id);

        // 创建User对象
        User user = new User(id, password1, email, phone, identity);

        // 调用DAO层的方法注册用户
        userDAO.registerUser(user);
    }

    private String determineIdentity(String id) {
        //        根据学号/教工号来判断是否是学生，还是管理员，还是老师，
        //        目前学生学号是年份+4位数字
        //        老师工号是1000到2000的四位数字+其他四位数字
        //        管理员学号是1000以内的四位数字+其他四位数字


        //        但是考虑到管理员不应该直接放在这种普通注册窗口中，之后再考虑
        int idNumber=Integer.parseInt(id.substring(0,4));
        String identity;
        if(idNumber>=1000 && idNumber<=2000){
            System.out.println("注册的是老师");//之后这种写到日志中去
            identity="老师";
        } else {
            System.out.println("注册的是学生");
            identity="学生";
        }
        return identity;
    }
}
