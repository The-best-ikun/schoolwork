package com.suep.demo06_25.controller;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.service.UserService;
import com.suep.demo06_25.utils.VerifyImageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LoginController {
//    绑定组件
    @FXML
    private TextField account;
    @FXML
    private TextField password;
    @FXML
    private Label info;
    @FXML
    private ImageView verifyImage;
    @FXML
    private TextField verify;

    private UserService userService;

    public LoginController(){
        userService=new UserService();
    }

    @FXML
    public void verifyAgain(){
        try {
            verifyImage.setImage(VerifyImageUtil.generateCaptchaImageView());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    绑定组件上的方法
    @FXML
    public void initialize(){
    //  初始化一下验证码
    //  利用了AWT，可能会有IO异常
        try {
            verifyImage.setImage(VerifyImageUtil.generateCaptchaImageView());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public  void  login(){
        verify.setText(VerifyImageUtil.verifyStr);//不用懒得填验证码，后面记得删掉
        String accountText=account.getText();
        String passwordText=password.getText();
        String verifyText=verify.getText();
//      这里先判断两个文本框里的数据是否为空
        if(accountText.isEmpty()){
            info.setText("账号为空，请先输入账号");
            info.setVisible(true);
        }else if(passwordText.isEmpty()){
            info.setText("密码为空，请输入密码");
            info.setVisible(true);
        }else if(verifyText.isEmpty()){
            info.setText("验证码为空，请输入验证码");
            info.setVisible(true);
        }
//      进入验证码验证,忽略字母大小写
        else if (verifyText.toUpperCase().equals(VerifyImageUtil.verifyStr.toUpperCase())) {
            info.setText("验证码正确");
        }
        if (userService.signIn(accountText,passwordText)){
            //登录成功进入主页
            Main.setId(account.getText());
            if(Integer.parseInt(accountText.substring(0,4))>2000){
                intoIndex1();//学生
            } else if (Integer.parseInt(accountText.substring(0,4))>=1000&&Integer.parseInt(accountText.substring(0,4))<=2000) {
                intoIndex2();//老师
            }else{
                intoIndex3();//管理员
            }

        }else{
            info.setText("用户ID或密码错误");
        }

    }

    //点击注册转换窗口的方法
    @FXML
    public void intoSignUp(){
        Main.changeView("signup-view.fxml");
    }
    //登录成功进入首页窗口
//       public void intoIndex(){Main.changeView("index-view.fxml");}
    public void intoIndex1(){
        Main.changeView("/com/suep/demo06_25/student/index-view.fxml");

    }
    public void intoIndex2(){
        Main.changeView("/com/suep/demo06_25/teacher/teacher-index-view.fxml");
    }
    public void intoIndex3(){
        Main.changeView("/com/suep/demo06_25/admin/admin-index-view.fxml");

    }

    //进入忘记密码的窗口

    @FXML
    void onHyperlink(){}


}
