package com.suep.demo06_25.controller.admin;

import com.suep.demo06_25.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class IndexViewController {
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public void initialize(){
        Main.loadRightFXML("/com/suep/demo06_25/admin/admin-index-right/student-crud-view.fxml",scrollPane);
    }
    @FXML
    public void onButton1(ActionEvent actionEvent) {
        Main.loadRightFXML("/com/suep/demo06_25/admin/admin-index-right/student-crud-view.fxml",scrollPane);
    }
    @FXML
    public void onButton2(ActionEvent actionEvent) {
        Main.loadRightFXML("/com/suep/demo06_25/admin/admin-index-right/teacher-crud-view.fxml",scrollPane);
    }
    @FXML
    public void onButton3(ActionEvent actionEvent) {
        Main.loadRightFXML("/com/suep/demo06_25/admin/admin-index-right/reviewcourse-view.fxml",scrollPane);
    }
    @FXML
    public void onButton4(ActionEvent actionEvent) {
    }
}
