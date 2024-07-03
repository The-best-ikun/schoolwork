package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.StudentDAO;
import com.suep.demo06_25.impl.StudentDAOImpl;
import com.suep.demo06_25.pojo.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;
    public StudentService(){
        studentDAO=new StudentDAOImpl();
    }
    public List<Student> showAllStudent(){
        return studentDAO.getAllStudents();
    }
    public Student getStudent(String id){return studentDAO.getStudent(id);}
    public List<Student> getAllStudent(){return studentDAO.getAllStudents();}

}
