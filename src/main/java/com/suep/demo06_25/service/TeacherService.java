package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.TeacherDAO;
import com.suep.demo06_25.impl.TeacherDAOImpl;

public class TeacherService {
    private TeacherDAO teacherDAO;


    public TeacherService() {
        teacherDAO = new TeacherDAOImpl();
    }
    public getTeacher(String id){
        return teacherDAO.getTeacher( id);

    }
}
