package com.suep.demo06_25.controller.student;


import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.service.AppraiseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class AppraiseViewController {

    private AppraiseService appraiseService;

    @FXML
    public TableView tableView;
    @FXML
    public TableColumn tnoColumn;

    @FXML
    public Label tno;
    @FXML
    public Label tname;
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;
    @FXML
    public Button button;


    public  AppraiseViewController(){
        appraiseService=new AppraiseService();
    }


    public void onTableView(SortEvent<TableView> tableViewSortEvent) {
    }

    

    public void onButton(ActionEvent actionEvent) {

    }


    public void initialize() {
        // 设置每列的单元格工厂和属性值
        tnoColumn.setCellValueFactory(new PropertyValueFactory<>("tno"));
        appraiseService.getAppraiseForStudent(Main.getId());


    }
}
