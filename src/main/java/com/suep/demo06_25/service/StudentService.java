package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.StudentDAO;
import com.suep.demo06_25.impl.StudentDAOImpl;

public class StudentService {
    private StudentDAO studentDAO;
    public StudentService(){
        studentDAO=new StudentDAOImpl();
    }
}
