package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.Appraise;
import com.suep.demo06_25.pojo.Grade;

import java.sql.SQLException;
import java.util.List;

public interface AppraiseDAO {
    //增
    public void addAppraise(Appraise appraise);

    //删
    public void deleteAppraise(String sno,String tno) throws SQLException;

    //改
    public void updateAppraise(Appraise appraise);

    //查
    Appraise getAppraise(String sno,String tno);

    //查所有
    List<Appraise> getAllAppraises();

    List<Appraise> getAppraiseForStudent(String id);
}
