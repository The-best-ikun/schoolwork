package com.suep.demo06_25.controller.student;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.service.StudentService;
import com.suep.demo06_25.service.TeacherService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicInfoController {

        @FXML
        private Label sno;
        @FXML
        private Label name;
        @FXML
        private Label sex;
        @FXML
        private Label age;
        @FXML
        private Label major;
        @FXML
        private Label phone;
        @FXML
        private Label address;

        @FXML
        private Label date;


        private StudentService studentService;
        //构造方法未完成前，还不能访问到组件，但是可以使用JavaFX的生命周期函数，而且不用加注解
        public BasicInfoController(){}
        public void initialize(){
            studentService =new StudentService();
            Student student=studentService.getStudent(Main.getId());
            sno.setText(student.getSno());
            name.setText(student.getName());
            sex.setText(student.getSex());
            age.setText(student.getAge());
            major.setText(student.getMajor());
            phone.setText(student.getPhone());
            address.setText(student.getAddress());
            date.setText(student.getTime().toString());
        }
}



