package com.suep.demo06_25.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ReviewCourseViewController {
    @FXML
    private Label label1;//显示课程号
    @FXML
    private Label label2;//显示申请人工号
    @FXML
    private Label label3;//显示课程名
    @FXML
    private Label label4;//显示课程位置
    @FXML
    private Label label5;//显示课程具体时间
    @FXML
    private  Label label6;//显示课程学分
    @FXML
    private Label label7;//显示提交申请时间
    @FXML
    private Button button1;//确认审核通过按钮
    @FXML
    private Button button2;//确认审核不通过按钮
    @FXML
    private TableView tableView;
}
