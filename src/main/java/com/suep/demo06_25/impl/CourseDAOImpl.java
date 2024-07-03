package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.CourseDAO;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    //增加语句
    private static final String INSERT_COURSE_SQL =
            "insert into course values(?,?,?,?,?,?) ";

    //删除语句
    private static final String DELETE_COURSE_SQL =
            "delete from course where cno=?";

    //修改语句
    private static final String UPDATE_COURSE_SQL =
            "update course set name = ?, location = ?, day = ?, time=?, credit = ? where cno=?";

    //查询语句
    private static final String SELECT_COURSE_SQL =
            "select * from course where cno=?";

    //查询所有课程
    private static final String SELECT_ALL_COURSES =
            "select * from course";

    private static  final String SELECT_STUDENT_ALL_CHOSEN_COURSE=
            "SELECT * FROM Course JOIN Grade ON Course.cno = Grade.cno WHERE Grade.sno =?";




//-----------------------------------

    @Override
    public void addCourse(Course course) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COURSE_SQL)) {

            preparedStatement.setString(1, course.getCno());
            preparedStatement.setString(2, course.getName());
            preparedStatement.setString(3, course.getLocation());
            preparedStatement.setString(4, course.getDay());
            preparedStatement.setString(5, course.getTime());
            preparedStatement.setInt(6, course.getCredit());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(String cno) throws SQLException {
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_COURSE_SQL);
        pst.setString(1,cno);
        pst.executeUpdate();
    }

    @Override
    public void updateCourse(Course course) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COURSE_SQL)) {

            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getLocation());
            preparedStatement.setString(3, course.getDay());
            preparedStatement.setString(4, course.getTime());
            preparedStatement.setInt(5, course.getCredit());
            preparedStatement.setString(6, course.getCno());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getCourse(String cno) {
        Course course = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSE_SQL)) {

            preparedStatement.setString(1, cno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String cno1 = resultSet.getString("cno");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                int credit = resultSet.getInt("credit");

                course = new Course(cno1, name, location, day, time, credit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cno = resultSet.getString("cno");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                int credit = resultSet.getInt("credit");

                Course course = new Course(cno, name, location, day, time, credit);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public List<Course> getChosenCourses(String sno) {//获得某个  学生已经选取的课程
        List<Course> courses = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_ALL_CHOSEN_COURSE)) {
            preparedStatement.setString(1,sno);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cno = resultSet.getString("cno");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                int credit = resultSet.getInt("credit");

                Course course = new Course(cno, name, location, day, time, credit);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }


}
