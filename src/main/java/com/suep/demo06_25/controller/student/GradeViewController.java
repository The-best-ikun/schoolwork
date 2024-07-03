package com.suep.demo06_25.controller.student;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Grade;
import com.suep.demo06_25.service.GradeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class GradeViewController {
    private GradeService gradeService;
    @FXML
    private TableView tableView;//表格
    @FXML
    private Label label;//显示平均绩点

    @FXML
    private TableColumn<Grade, String> tnoColumn;
    @FXML
    private TableColumn<Grade, String> cnoColumn;
    @FXML
    private TableColumn<Grade, Double> gradeColumn;

    private ObservableList<Grade> gradeData = FXCollections.observableArrayList();

    public GradeViewController() {
        gradeService=new GradeService();
    }

    public void initialize() {
        // 设置每列的数据
        tnoColumn.setCellValueFactory(new PropertyValueFactory<>("tno"));
        cnoColumn.setCellValueFactory(new PropertyValueFactory<>("cno"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        // 假设这是从数据库或其他地方获取的数据
        List<Grade> grades = gradeService.getGradeBySid(Main.getId());
        gradeData.addAll(grades);

        tableView.setItems(gradeData);
    }
    @FXML
    void onTableView(){

    }

}
