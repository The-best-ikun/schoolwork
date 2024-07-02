package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.TeacherDAO;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.pojo.Teacher;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    //增加语句
    private static final String INSERT_TEACHER_SQL =
            "insert into teacher values(?,?,?,?,?,?,?) ";

    //删除语句
    private static final String DELETE_TEACHER_SQL =
            "delete from teacher where tno=?";

    //修改语句
    private static final String UPDATE_TEACHER_SQL =
            "update teacher set name = ?, age = ?, phone = ?, dept=?, professional = ?, starttime = ? where tno=?";

    //查询语句
    private static final String SELECT_TEACHER_SQL =
            "select * from teacher where tno=?";

    //查询所有教师
    private static final String SELECT_ALL_TEACHERS =
            "select * from teacher";

//-----------------------------------

    @Override
    public void addTeacher(Teacher teacher) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_SQL)) {

            preparedStatement.setString(1, teacher.getTno());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setInt(3, teacher.getAge());
            preparedStatement.setString(4, teacher.getPhone());
            preparedStatement.setString(5, teacher.getDept());
            preparedStatement.setString(6, teacher.getProfessional());
            preparedStatement.setDate(7, teacher.getStarttime());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacher(String tno) throws SQLException {
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_TEACHER_SQL);
        pst.setString(1,tno);
        pst.executeUpdate();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TEACHER_SQL)) {

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setInt(2, teacher.getAge());
            preparedStatement.setString(3, teacher.getPhone());
            preparedStatement.setString(4, teacher.getDept());
            preparedStatement.setString(5, teacher.getProfessional());
            preparedStatement.setDate(6, teacher.getStarttime());
            preparedStatement.setString(7, teacher.getTno());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacher(String tno) {
        Teacher teacher = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_SQL)) {

            preparedStatement.setString(1, tno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String tno1 = resultSet.getString("tno");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String dept = resultSet.getString("dept");
                String professional = resultSet.getString("professional");
                Date starttime = resultSet.getDate("starttime");

                teacher = new Teacher(tno1, name, age, phone, dept, professional, starttime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String tno1 = resultSet.getString("tno");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String dept = resultSet.getString("dept");
                String professional = resultSet.getString("professional");
                Date starttime = resultSet.getDate("starttime");

                Teacher teacher = new Teacher(tno1, name, age, phone, dept, professional, starttime);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
