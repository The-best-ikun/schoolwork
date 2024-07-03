package com.suep.demo06_25.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import static com.suep.demo06_25.Main.changeView;
import static com.suep.demo06_25.Main.loadRightFXML;

public class IndexController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private void initialize() {
        // 初始加载第一个FXML文件
        loadRightFXML("student/index-right/basicInfo-view.fxml",scrollPane);
        System.out.println("加载右端初始界面");

    }


    @FXML
    private void onButton1(){
        loadRightFXML("student/index-right/basicInfo-view.fxml",scrollPane);
    }
    @FXML
    private void onButton2(){
        loadRightFXML("student/index-right/grade-view.fxml",scrollPane);
        System.out.println("有反应吗");
    }
    @FXML
    private void onButton3(){
        loadRightFXML("student/index-right/lessonTable.fxml",scrollPane);

    }
    @FXML
    private void onButton4(){
        loadRightFXML("student/index-right/lesson-choice-view.fxml",scrollPane);

    }
    @FXML
    private void onButton5(){
        loadRightFXML("student/index-right/appraise-view.fxml",scrollPane);
    }
    @FXML
    private void onButton6(){
        changeView("/com/suep/demo06_25/login-view.fxml");
    }



}
