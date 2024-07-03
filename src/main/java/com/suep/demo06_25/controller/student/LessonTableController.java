package com.suep.demo06_25.controller.student;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.MyData;
import com.suep.demo06_25.service.CourseService;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class LessonTableController {


    @FXML
    private TableView<Course> tableView;
    @FXML
    private TableColumn<Course, String> cnoColumn;
    @FXML
    private TableColumn<Course, String> nameColumn;
    @FXML
    private TableColumn<Course, String> locationColumn;
    @FXML
    private TableColumn<Course, String> dayColumn;
    @FXML
    private TableColumn<Course, String> timeColumn;
    @FXML
    private TableColumn<Course, Integer> creditColumn;

    private ObservableList<Course> courseData = FXCollections.observableArrayList();
    private CourseService courseService;

    public LessonTableController() {
        courseService=new CourseService();
    }

    public void initialize() {
        // 设置每列的单元格工厂和属性值
        cnoColumn.setCellValueFactory(new PropertyValueFactory<>("cno"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));

        List<Course> courses = courseService.getCourseForStudent(Main.getId()); // 从CourseService获取数据
        courseData.clear();
        courseData.addAll(courses);
        tableView.setItems(courseData);
    }
}

