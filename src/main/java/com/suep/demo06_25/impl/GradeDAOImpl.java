package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.GradeDAO;
import com.suep.demo06_25.pojo.Grade;
import com.suep.demo06_25.pojo.Student;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GradeDAOImpl implements GradeDAO {
    //增加语句
    private static final String INSERT_GRADE_SQL =
            "insert into grade values(?,?,?,?) ";

    //删除语句
    private static final String DELETE_GRADE_SQL =
            "delete from grade where sno=? and tno=? and cno=?";

    //修改语句
    private static final String UPDATE_GRADE_SQL =
            "update grade set grade=? where sno=? and tno=? and cno=?";

    //查询语句
    private static final String SELECT_GRADE_SQL =
            "select * from grade where sno=? and tno=? and cno=?";

    //查询所有成绩
    private static final String SELECT_ALL_GRADES =
            "select * from grade";

//-----------------------------------

    @Override
    public void addGrade(Grade grade) {  //增
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GRADE_SQL)) {

            preparedStatement.setString(1, grade.getSno());
            preparedStatement.setString(2, grade.getTno());
            preparedStatement.setString(3, grade.getCno());
            preparedStatement.setDouble(4, grade.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGrade(String sno, String tno, String cno) throws SQLException {  //删
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_GRADE_SQL);
        pst.setString(1,sno);
        pst.setString(2,tno);
        pst.setString(3,cno);
        pst.executeUpdate();
    }

    @Override
    public void updateGrade(Grade grade) {  //改
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GRADE_SQL)) {

            preparedStatement.setDouble(1, grade.getGrade());
            preparedStatement.setString(2, grade.getSno());
            preparedStatement.setString(3, grade.getTno());
            preparedStatement.setString(4, grade.getCno());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Grade getGrade(String sno, String tno, String cno) {  //查
        Grade grade = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GRADE_SQL)) {

            preparedStatement.setString(1, sno);
            preparedStatement.setString(2, tno);
            preparedStatement.setString(3, cno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String sno1 = resultSet.getString("sno");
                String tno1 = resultSet.getString("tno");
                String cno1 = resultSet.getString("cno");
                int grade1 = resultSet.getInt("grade");

                grade = new Grade(sno1, tno1, cno1, grade1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    @Override
    public List<Grade> getAllGrades() {  //查所有
        List<Grade> grades = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GRADES)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sno = resultSet.getString("sno");
                String tno = resultSet.getString("tno");
                String cno = resultSet.getString("cno");
                Double grade = resultSet.getDouble("grade");
                byte[] picture = resultSet.getBytes("picture");
                Grade grade2 = new Grade(sno, tno,cno,grade);
                grades.add(grade2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }
}
