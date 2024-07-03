package com.suep.demo06_25.service;

import com.suep.demo06_25.Main;
import com.suep.demo06_25.dao.AppraiseDAO;
import com.suep.demo06_25.impl.AppraiseDAOImpl;
import com.suep.demo06_25.pojo.Appraise;

import java.util.ArrayList;
import java.util.List;

public class AppraiseService {
    private AppraiseDAO appraiseDAO;
    public AppraiseService(){
        appraiseDAO=new AppraiseDAOImpl();
    }
    public List<Appraise> getAppraiseForStudent(String id){
        List<Appraise> appraiseList=new ArrayList<>();
        appraiseList=appraiseDAO.getAppraiseForStudent(id);
        return appraiseList;
    }
}
