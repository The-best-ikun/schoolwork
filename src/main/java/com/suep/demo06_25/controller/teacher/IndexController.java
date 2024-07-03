package com.suep.demo06_25.controller.teacher;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.service.TeacherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class IndexController {

    private TeacherService teacherService;
    public IndexController(){
        teacherService=new TeacherService();
    }

    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button6;
    @FXML
    public Button button7;
    @FXML
    public ScrollPane scrollPane;

    public void initialize(){
        Main.loadRightFXML("/com/suep/demo06_25/teacher/teacher-index-right/basicInfo-view.fxml",scrollPane);
    }
    @FXML
    public void onButton1(ActionEvent actionEvent) {
        Main.loadRightFXML("/com/suep/demo06_25/teacher/teacher-index-right/basicInfo-view.fxml",scrollPane);
    }

    @FXML
    public void onButton2(ActionEvent actionEvent) {
        Main.loadRightFXML("/com/suep/demo06_25/teacher/teacher-index-right/work-lesson-view.fxml",scrollPane);
    }
    @FXML
    public void onButton3(ActionEvent actionEvent) {
    }
    @FXML
    public void onButton4(ActionEvent actionEvent) {
    }
    @FXML
    public void onButton5(ActionEvent actionEvent) {
    }
    @FXML
    public void onButton6(ActionEvent actionEvent) {
    }
    @FXML
    public void onButton7(ActionEvent actionEvent) {
    }
}
