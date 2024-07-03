package com.suep.demo06_25.controller.student;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.service.CourseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class LessonChoiceViewController {



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

    @FXML
    private Label cno;//显示课程号
    @FXML
    private  Label name; //显示课程名
    @FXML
    private Label courseLocation;//显示课程教室
    @FXML
    private Label day;//显示课程日
    @FXML
    private Label time;//显示课程具体时间
    @FXML
    private Label credit;
    @FXML
    private Button button1;//确认选课按钮
    @FXML
    private Button button2;//确认退课

    private ObservableList<Course> courseData = FXCollections.observableArrayList();
    private CourseService courseService;


    public LessonChoiceViewController() {
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

        List<Course> courses = courseService.getNotChosenCourseForStudent(Main.getId()); // 从CourseService获取数据
        courseData.clear();
        courseData.addAll(courses);
        tableView.setItems(courseData);
    }
    @FXML
    private void onButton1(){

    }
    @FXML
    private void onButton2(){

    }
    @FXML
    private void onTableView(){

    }



}
