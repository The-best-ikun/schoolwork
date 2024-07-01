package com.suep.demo06_25.controller.admin;

import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.service.StudentService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class StudentCrudViewController {

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

    public StudentCrudViewController() {
        studentService=new StudentService();
    }

    @FXML
    private void initialize(){

        String[] fields = {"sno", "name", "classno","sex", "major", "phone","address","time","dept"};
        String[] fields1={"学号","姓名","班级","性别","专业","联系电话","籍贯","入学时间","院系"};


        for (int i=0;i<fields.length;i++) {
            TableColumn<Student, Object> column = new TableColumn<>(fields1[i]);
            column.setCellValueFactory(new PropertyValueFactory<>(fields[i]));
            tableView.getColumns().add(column);
        }
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
    private void handleRowClick(MouseEvent event) {
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
