package com.suep.demo06_25.service;

import com.suep.demo06_25.dao.GradeDAO;
import com.suep.demo06_25.impl.GradeDAOImpl;
import com.suep.demo06_25.pojo.Grade;

import java.util.List;

public class GradeService {
    private GradeDAO gradeDAO;

    public GradeService() {
        gradeDAO=new GradeDAOImpl();
    }

    public List<Grade> getGradeBySid(String id){
        return gradeDAO.getGradeBySno(id);
    }
    public List<Grade> getGradeByTid(String id){
        return gradeDAO.getGradeByTno(id);
    }
}
