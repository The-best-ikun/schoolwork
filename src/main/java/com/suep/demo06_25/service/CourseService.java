package com.suep.demo06_25.service;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.dao.CourseDAO;
import com.suep.demo06_25.dao.GradeDAO;
import com.suep.demo06_25.impl.CourseDAOImpl;
import com.suep.demo06_25.impl.GradeDAOImpl;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CourseService {
    private CourseDAO courseDAO;
    private GradeDAO gradeDAO;

    public CourseService() {
        courseDAO=new CourseDAOImpl();
        gradeDAO=new GradeDAOImpl();
    }

    public List<Course> getCourseForStudent(String id){
        //先看选课表里有没有数据
        List<Grade> grades=gradeDAO.getGradeBySno(id);
        List<Course> courses=new ArrayList<>();
        for (Grade grade:
             grades) {
            String cno=grade.getCno();
            Course course=courseDAO.getCourse(cno);
            courses.add(course);
        }
        return courses;
    }
//    获取学生已选课程列表
//    获取到全部的课程列表
//    比较和筛选：遍历全部课程列表，对于每一个课程，检查它是否出现在学生已选课程列表中来完成。
    public List<Course> getNotChosenCourseForStudent(String id) {

        List<Course> allCourses=new ArrayList<>();
        List<Course> chosenCourses=new ArrayList<>();


        allCourses.addAll(courseDAO.getAllCourses());//    获取到全部的课程列表
        chosenCourses.addAll(courseDAO.getChosenCourses(Main.getId()));

        //这段网络查的，好高级啊
        Map<String, Course> chosenCourseMap = chosenCourses.stream()
                .collect(Collectors.toMap(Course::getCno, Function.identity()));

        List<Course> filteredCourses = allCourses.stream()
                .filter(course -> !chosenCourseMap.containsKey(course.getCno()))
                .collect(Collectors.toList());

        return filteredCourses;
    }

    public List<Course> getWorkLesson(String id) {
        List<Grade> gradeList=gradeDAO.getGradeByTno(id);
        List<Course> courseList=new ArrayList<>();
        for (Grade grade:
             gradeList) {
            courseList.add(courseDAO.getCourse(grade.getCno()));
        }
        return courseList;
    }
}
