package com.suep.demo06_25.controller;

import com.suep.demo06_25.pojo.MyData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LessonTableController {
    @FXML
    private TableView<MyData> tableView;

    @FXML
    private TableColumn<MyData, String> firstColumn;

    @FXML
    private void initialize() {
        // 设置列名
        firstColumn.setText("列名");

        // 设置单元格值工厂，假设MyData类有一个名为"name"的属性
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 初始化数据
        ObservableList<MyData> data = FXCollections.observableArrayList(
                new MyData("数据1"),
                new MyData("数据2"),
                new MyData("数据3")
        );

        // 将数据绑定到TableView
        tableView.setItems(data);
    }




}

