package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.TeacherDAO;
import com.suep.demo06_25.impl.TeacherDAOImpl;
import com.suep.demo06_25.pojo.Teacher;

public class TeacherService {
    private TeacherDAO teacherDAO;


    public TeacherService() {
        teacherDAO = new TeacherDAOImpl();
    }

    //   获取老师
    public Teacher getTeacher(String id){
        return teacherDAO.getTeacher(id);

    }
}
