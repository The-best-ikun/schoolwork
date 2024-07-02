package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {
    //增
    public void addTeacher(Teacher teacher);

    //删
    public void deleteTeacher(String tno) throws SQLException;

    //改
    public void updateTeacher(Teacher teacher);

    //查
    Teacher getTeacher(String tno);

    //查所有
    List<Teacher> getAllTeachers();
}
