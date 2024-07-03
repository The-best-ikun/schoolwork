package com.suep.demo06_25.controller.teacher;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClassGradeViewController {
    @FXML
    private TableView tableView;//成绩表
    @FXML
    private LineChart lineChart;//成绩预览
    @FXML
    private TextField textField;//输入课号对话框
    @FXML
    private TextField textField2;//成绩显示框
    @FXML
    private Button button;//填入成绩按钮
    @FXML
    private  Button button2;//修改成绩按钮
    @FXML
    private PieChart pieChart;//成绩分布情况图
}
