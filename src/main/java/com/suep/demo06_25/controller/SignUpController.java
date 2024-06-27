package com.suep.demo06_25.controller;

import com.suep.demo06_25.service.UserService;
import com.suep.demo06_25.untils.MySQLUntil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField id;
    @FXML
    private TextField password1;
    @FXML
    private TextField password2;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private Label info;

    private UserService userService;

    public SignUpController() {
        userService = new UserService();
    }
    @FXML
    public void  signUp(){
        String idText=id.getText();
        String passwordText1=password1.getText();
        String passwordText2=password2.getText();
        String phoneText=phone.getText();
        String emailText=email.getText();

        //进行非空判断
        if(idText.isEmpty()){
            info.setText("学号/教工号不能为空");
            return;
        }else if (phoneText.isEmpty()){
            info.setText("手机号不能为空");
            return;
        } else if (emailText.isEmpty()) {
            info.setText("邮件地址不能为空");
            return;
        } else if(passwordText1.isEmpty()){
            info.setText("密码不能为空");
            return;
        }else if(passwordText2.isEmpty()){
            info.setText("请再次确认密码");
            return;
        } else if (!passwordText1.equals(passwordText2)){
            info.setText("两次密码输入不一致");
            return;
        }
        try {
            userService.register(idText, passwordText1, passwordText2, phoneText, emailText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        showSuccessAlert();

    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("账号注册");
        alert.setHeaderText("注册成功");
        alert.setContentText("请跳转到登录界面登录");
        alert.showAndWait();
    }
}
