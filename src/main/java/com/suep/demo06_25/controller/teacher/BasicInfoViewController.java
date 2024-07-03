package com.suep.demo06_25.controller.teacher;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.pojo.Teacher;
import com.suep.demo06_25.service.TeacherService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicInfoViewController {

    private TeacherService teacherService;

    public BasicInfoViewController() {
        teacherService=new TeacherService();
    }

    @FXML
    public Label name;
    @FXML
    public Label sex;
    @FXML
    public Label age;
    @FXML
    public Label professional;
    @FXML
    public Label phone;
    @FXML
    public Label dept;
    @FXML
    public Label starttime;
    @FXML
    public Label tno;

    public void initialize(){
        Teacher teacher=teacherService.getTeacher(Main.getId());
        tno.setText(teacher.getTno());
        name.setText(teacher.getName());
        age.setText(String.valueOf(teacher.getAge()));
        phone.setText(teacher.getPhone());
        dept.setText(teacher.getDept());
        starttime.setText(String.valueOf(teacher.getStarttime()));
        professional.setText(teacher.getProfessional());
    }
}
