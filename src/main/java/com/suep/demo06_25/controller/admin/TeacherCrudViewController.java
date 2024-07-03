package com.suep.demo06_25.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TeacherCrudViewController {
    @FXML
    private TableView tableView;
    @FXML
    private Label tno;//显示工号信息
    @FXML
    private TextField textField1; //显示姓名
    @FXML
    private TextField textField2; //显示电话
    @FXML
    private DatePicker datePicker;//显示入职时间
    @FXML
    private TextField textField3;//显示根据工号查找
    @FXML
    private Button button1;//按钮根据工号查找
    @FXML
    private TextField textField4;//显示年龄
    @FXML
    private TextField textField5;//显示院系
    @FXML
    private TextField textField6;//显示职称
    @FXML
    private Button button2;//按钮查询所有
    @FXML
    private Button button3;//增加教师信息按钮
    @FXML
    private Button button4;//修改教师信息按钮
    @FXML
    private Button button5;//删除教师信息按钮
}
