package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.StudentDAO;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//哈哈哈

public class StudentDAOImpl implements StudentDAO {
    //    直接在这里声明静态常量

    //    增加学生
    private static final String INSERT_STUDENT_SQL =
            "INSERT INTO student (sno, name, sex,classno, age, major, phone, address, dept, time, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";

    //    删除学生
    private static final String DELETE_STUDENT_SQL =
            "DELETE FROM student WHERE sno = ?;";

    //    更新学生
    private static final String UPDATE_STUDENT_SQL =
            "UPDATE student SET name = ?, sex = ?, age = ?,classno=?, major = ?, phone = ?, address = ?, dept = ?, time = ?, picture = ? WHERE sno = ?;";

    //    查询某个学生
    private static final String SELECT_STUDENT_BY_ID =
            "SELECT * FROM student WHERE sno = ?;";

    //   查询所有学生
    private static final String SELECT_ALL_STUDENTS =
            "SELECT * FROM student;";

    //   根据学院查询学生
    private static final String SELECT_STUDENTS_BY_COURSE =
            "SELECT * FROM student WHERE dept = ?;";

    //   查询学生数量
    private static final String SELECT_STUDENTS_BY_DEPARTMENT =
            "SELECT * FROM student WHERE dept = ?;";

    //   查询学生是否存在
    private static final String CHECK_STUDENT_EXISTS =
            "SELECT EXISTS(SELECT 1 FROM student WHERE sno = ?);";

    //查询学生数量
    private static final String GET_STUDENT_COUNT =
            "SELECT COUNT(*) FROM student;";

//-----------------------------------

    @Override
    public void addStudent(Student student) { //增
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            preparedStatement.setString(1, student.getSno());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSex());
            preparedStatement.setString(4, student.getAge());
            preparedStatement.setString(5, student.getClassno());
            preparedStatement.setString(6, student.getMajor());
            preparedStatement.setString(7, student.getPhone());
            preparedStatement.setString(8, student.getAddress());
            preparedStatement.setString(9, student.getDept());
            preparedStatement.setDate(10, new java.sql.Date(student.getTime().getTime()));
            preparedStatement.setBytes(11, student.getPicture());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String studentId) throws SQLException { //删
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_STUDENT_SQL);
        pst.setString(1,studentId);
        pst.executeUpdate();
    }

    @Override
    public void updateStudent(Student student) { //改

        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getAge());
            preparedStatement.setString(4, student.getClassno());
            preparedStatement.setString(5, student.getMajor());
            preparedStatement.setString(6, student.getPhone());
            preparedStatement.setString(7, student.getAddress());
            preparedStatement.setString(8, student.getDept());
            preparedStatement.setDate(9,new java.sql.Date(student.getTime().getTime()));
            preparedStatement.setBytes(10, student.getPicture());
            preparedStatement.setString(11, student.getSno());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudent(String studentId) { //查
        Student student = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {

            preparedStatement.setString(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String sno = resultSet.getString("sno");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String age = resultSet.getString("age");
                String classno = resultSet.getString("classno");
                String major = resultSet.getString("major");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String dept = resultSet.getString("dept");
                Date time = resultSet.getDate("time");
                byte[] picture = resultSet.getBytes("picture");

                student = new Student(sno, name, sex, classno,age, major, phone, address, dept, time, picture);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() { //加载所有学生
        List<Student> students = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sno = resultSet.getString("sno");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String age = resultSet.getString("age");
                String classno = resultSet.getString("classno");
                String major = resultSet.getString("major");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String dept = resultSet.getString("dept");
                Date time = resultSet.getDate("time");
                byte[] picture = resultSet.getBytes("picture");
                Student student = new Student(sno, name, sex, age,classno, major, phone, address, dept, time, picture);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> getStudentsByDepartment(String department) {
        return null;
    }

    @Override
    public boolean studentExists(String studentId) {
        return false;
    }

    @Override
    public int getStudentCount() {
        return 0;
    }
}
