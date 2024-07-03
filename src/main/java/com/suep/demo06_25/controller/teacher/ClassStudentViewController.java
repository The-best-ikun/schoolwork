package com.suep.demo06_25.controller.teacher;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.BatchUpdateException;

public class ClassStudentViewController {
@FXML
    private TextField sno;//输入学号,根据学号查找
    @FXML
    private TextField cno;//输入课号，加学生
    @FXML
    private TextField sno1;//输入学号，添加该学生
    @FXML
    private Button button1;//根据学号查找按钮
    @FXML
    private Button button2;//删除该学生按钮
    @FXML
    private Button button3;//增加该学生
}
