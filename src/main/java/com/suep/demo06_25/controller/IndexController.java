package com.suep.demo06_25.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

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
        scrollPane=new ScrollPane();
        // 初始加载第一个FXML文件
        loadRightFXML("index-right/basicInfo-view.fxml",scrollPane);
    }


    @FXML
    private void onButton1(){
        loadRightFXML("index-right/basicInfo-view.fxml",scrollPane);
    }
    @FXML
    private void onButton2(){
        loadRightFXML("index-right/lessonTable.fxml",scrollPane);
    }
    @FXML
    private void onButton3(){

    }
    @FXML
    private void onButton4(){

    }
    @FXML
    private void onButton5(){

    }
    @FXML
    private void onButton6(){

    }



}
