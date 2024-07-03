package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.ReviewCourseDAO;
import com.suep.demo06_25.pojo.Course;
import com.suep.demo06_25.pojo.ReviewCourse;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewCourseDAOImpl implements ReviewCourseDAO {
    //增加语句
    private static final String INSERT_REVIEWCOURSE_SQL =
            "insert into reviewcourse values(?,?,?,?,?,?,?,?,?) ";

    //删除语句
    private static final String DELETE_REVIEWCOURSE_SQL =
            "delete from reviewcourse where cno=?";

    //修改语句
    private static final String UPDATE_REVIEWCOURSE_SQL =
            "update reviewcourse set tno=?,name=?,location=?,day=?,time=?,credit=?,committime=?,state=? where cno=?";

    //查询语句
    private static final String SELECT_REVIEWCOURSE_SQL =
            "select * from reviewcourse where cno=?";

    //查询所有课程
    private static final String SELECT_ALL_REVIEWCOURSES =
            "select * from reviewcourse";

//-----------------------------------

    @Override
    public void addReviewCourse(ReviewCourse reviewcourse) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEWCOURSE_SQL)) {

            preparedStatement.setString(1, reviewcourse.getCno());
            preparedStatement.setString(2, reviewcourse.getTno());
            preparedStatement.setString(3, reviewcourse.getName());
            preparedStatement.setString(4, reviewcourse.getLocation());
            preparedStatement.setString(5, reviewcourse.getDay());
            preparedStatement.setString(6, reviewcourse.getTime());
            preparedStatement.setInt(7, reviewcourse.getCredit());
            preparedStatement.setDate(8, reviewcourse.getCommittime());
            preparedStatement.setString(9, reviewcourse.getState());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReviewCourse(String cno) throws SQLException {
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_REVIEWCOURSE_SQL);
        pst.setString(1,cno);
        pst.executeUpdate();
    }

    @Override
    public void updateReviewCourse(ReviewCourse reviewcourse) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEWCOURSE_SQL)) {

            preparedStatement.setString(9, reviewcourse.getCno());
            preparedStatement.setString(1, reviewcourse.getTno());
            preparedStatement.setString(2, reviewcourse.getName());
            preparedStatement.setString(3, reviewcourse.getLocation());
            preparedStatement.setString(4, reviewcourse.getDay());
            preparedStatement.setString(5, reviewcourse.getTime());
            preparedStatement.setInt(6, reviewcourse.getCredit());
            preparedStatement.setDate(7, reviewcourse.getCommittime());
            preparedStatement.setString(8, reviewcourse.getState());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ReviewCourse getReviewCourse(String cno) {
        ReviewCourse reviewcourse = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEWCOURSE_SQL)) {

            preparedStatement.setString(1, cno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String cno1 = resultSet.getString("cno");
                String tno1 = resultSet.getString("tno");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                int credit = resultSet.getInt("credit");
                Date committime = resultSet.getDate("committime");
                String state = resultSet.getString("state");

                reviewcourse = new ReviewCourse(cno1,tno1,name,location,day,time,credit,committime,state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewcourse;
    }

    @Override
    public List<ReviewCourse> getAllReviewCourses() {
        List<ReviewCourse> reviewcourses = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEWCOURSES)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cno1 = resultSet.getString("cno");
                String tno1 = resultSet.getString("tno");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                int credit = resultSet.getInt("credit");
                Date committime = resultSet.getDate("committime");
                String state = resultSet.getString("state");

                ReviewCourse reviewcourse = new ReviewCourse(cno1,tno1,name,location,day,time,credit,committime,state);
                reviewcourses.add(reviewcourse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewcourses;
    }
}
