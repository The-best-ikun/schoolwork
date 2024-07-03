package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.Grade;

import java.sql.SQLException;
import java.util.List;

public interface GradeDAO {
    //增
    public void addGrade(Grade grade);

    //删
    public void deleteGrade(String sno,String tno,String cno) throws SQLException;

    //改
    public void updateGrade(Grade grade);

    //查
    Grade getGrade(String sno,String tno,String cno);

    //查所有
    List<Grade> getAllGrades();

    List<Grade> getGradeBySno(String id);

    List<Grade> getGradeByTno(String id);
}

