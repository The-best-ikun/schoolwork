package com.suep.demo06_25.controller;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicInfoController {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;


    private StudentService studentService;
    public BasicInfoController(){
        studentService=new StudentService();


        Student student=studentService.getStudent(Main.getId());
        label1.setText(student);
    }


}
