package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.Grade;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
    //增
    public void addCourse(Course course);

    //删
    public void deleteCourse(String cno) throws SQLException;

    //改
    public void updateCourse(Course course);

    //查
    Course getCourse(String cno);

    //查所有
    List<Course> getAllCourses();
}
