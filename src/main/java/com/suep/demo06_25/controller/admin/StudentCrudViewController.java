package com.suep.demo06_25.controller.admin;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Grade;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class StudentCrudViewController {
    @FXML
    public TableColumn snoColumn;
    @FXML
    public TableColumn nameColumn;
    @FXML
    public TableColumn ageColumn;
    @FXML
    public TableColumn sexColumn;
    @FXML
    public TableColumn classnoColumn;
    @FXML
    public TableColumn majorColumn;
    @FXML
    public TableColumn phoneColumn;
    @FXML
    public TableColumn addressColumn;
    @FXML
    public TableColumn timeColumn;
    @FXML
    public TableColumn deptColumn;
    private StudentService studentService;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private Label label;//学号

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
    @FXML
    private TextField textField7;
    @FXML
    private DatePicker datePicker;

    private ObservableList<Student> studentData = FXCollections.observableArrayList();

    public StudentCrudViewController() {
        studentService=new StudentService();
    }

    @FXML
    private void initialize(){

//        String[] fields = {"sno", "name", "classno","sex", "major", "phone","address","time","dept"};
//        String[] fields1={"学号","姓名","班级","性别","专业","联系电话","籍贯","入学时间","院系"};


        // 设置每列的数据
        snoColumn.setCellValueFactory(new PropertyValueFactory<>("sno"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        classnoColumn.setCellValueFactory(new PropertyValueFactory<>("classno"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        deptColumn.setCellValueFactory(new PropertyValueFactory<>("dept"));
        //
        List<Student> students = studentService.getAllStudent();
        studentData.addAll(students);
        tableView.setItems(studentData);
    }
    //    增删改查的四个按钮的方法事件
    @FXML
    private void onButton4(){
        List<Student> students= studentService.showAllStudent();
        tableView.setItems(FXCollections.observableArrayList(students));
    }
    @FXML
    private void onButton1(){
    }
    @FXML
    private void onButton2(){
    }
    @FXML
    private void onButton3(){
    }
    @FXML
    private void onTableView(MouseEvent event) {
        if (event.getClickCount() == 2) { // 检查是否为双击事件
            Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                // 这里可以处理选中的Student对象
                System.out.println("选中的学生信息: " + selectedStudent);
                textField1.setText(selectedStudent.getName());
                textField2.setText(selectedStudent.getSex());
                textField3.setText(selectedStudent.getAge());
                textField4.setText(selectedStudent.getClassno());
                textField5.setText(selectedStudent.getMajor());
                textField6.setText(selectedStudent.getAddress());
                textField7.setText(selectedStudent.getName());


            }
        }

    }


}
