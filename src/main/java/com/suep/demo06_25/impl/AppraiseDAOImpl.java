package com.suep.demo06_25.impl;

import com.suep.demo06_25.dao.AppraiseDAO;
import com.suep.demo06_25.pojo.Appraise;
import com.suep.demo06_25.pojo.Grade;
import com.suep.demo06_25.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppraiseDAOImpl implements AppraiseDAO {
    //增加语句
    private static final String INSERT_APPRAISE_SQL =
            "insert into appraise values(?,?,?,?) ";

    //删除语句
    private static final String DELETE_APPRAISE_SQL =
            "delete from appraise where sno=? and tno=?";

    //修改语句
    private static final String UPDATE_APPRAISE_SQL =
            "update appraise set grade=?, appraise=? where sno=? and tno=?";

    //查询语句
    private static final String SELECT_APPRAISE_SQL =
            "select * from appraise where sno=? and tno=?";

    //查询所有评价
    private static final String SELECT_ALL_APPRAISES =
            "select * from appraise";
    private static final String SELECT_APPRAISES_BY_SNO =
            "select * from appraise where sno= ? and grade is not null";//这里的逻辑就是一旦学生选了某个老师的课后就会在appraise里插入一个grade和appriase

//-----------------------------------


    @Override
    public void addAppraise(Appraise appraise) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPRAISE_SQL)) {

            preparedStatement.setString(1, appraise.getSno());
            preparedStatement.setString(2, appraise.getTno());
            preparedStatement.setDouble(3, appraise.getGrade());
            preparedStatement.setString(4, appraise.getAppraise());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAppraise(String sno, String tno) throws SQLException {
        Connection connection = MySQLUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(DELETE_APPRAISE_SQL);
        pst.setString(1,sno);
        pst.setString(2,tno);
        pst.executeUpdate();
    }

    @Override
    public void updateAppraise(Appraise appraise) {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPRAISE_SQL)) {

            preparedStatement.setString(3, appraise.getSno());
            preparedStatement.setString(4, appraise.getTno());
            preparedStatement.setDouble(1, appraise.getGrade());
            preparedStatement.setString(2, appraise.getAppraise());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Appraise getAppraise(String sno, String tno) {
        Appraise appraise = null;
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPRAISE_SQL)) {

            preparedStatement.setString(1, sno);
            preparedStatement.setString(2, tno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String sno1 = resultSet.getString("sno");
                String tno1 = resultSet.getString("tno");
                Double grade1 = resultSet.getDouble("grade");
                String appraise1 = resultSet.getString("grade");

                appraise = new Appraise(sno1, tno1, grade1,appraise1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appraise;
    }

    @Override
    public List<Appraise> getAllAppraises() {
        List<Appraise> appraises = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPRAISES)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sno1 = resultSet.getString("sno");
                String tno1 = resultSet.getString("tno");
                Double grade1 = resultSet.getDouble("grade");
                String appraise1 = resultSet.getString("appraise");
                Appraise appraise2 = new Appraise(sno1, tno1,grade1,appraise1);
                appraises.add(appraise2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appraises;
    }

    @Override
    public List<Appraise> getAppraiseForStudent(String id) {
        List<Appraise> appraises = new ArrayList<>();
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPRAISES_BY_SNO)) {
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String sno1 = resultSet.getString("sno");
                String tno1 = resultSet.getString("tno");
                Double grade1 = resultSet.getDouble("grade");
                String appraise1 = resultSet.getString("appraise");
                Appraise appraise2 = new Appraise(sno1, tno1,grade1,appraise1);
                appraises.add(appraise2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appraises;

    }
}
