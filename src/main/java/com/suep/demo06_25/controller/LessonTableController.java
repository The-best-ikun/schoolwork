package com.suep.demo06_25.controller;

import com.suep.demo06_25.pojo.MyData;
import javafx.beans.binding.Bindings;
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
        // 这部分稍微有点复杂。想象一下，你有一个机器人，它的任务是给你拿书。你需要告诉机器人：“从书的属性中找到‘name’，然后告诉我。”
        // 在JavaFX中，PropertyValueFactory就是这个机器人，它知道如何从MyData类的对象中找到名为name的属性，并把这个属性的值显示在表格的单元格中。
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 初始化数据，这也是个新奇东西，好像是用到了观察着设计模式，这里很流弊的一点就是每一行都可以封装成一个对象，表格对应列可以自动取值。
        ObservableList<MyData> data = FXCollections.observableArrayList(
                new MyData("第一节"),
                new MyData("第二节"),
                new MyData("第三节")
        );

        // 将数据绑定到TableView
        tableView.setItems(data);
    }




}

