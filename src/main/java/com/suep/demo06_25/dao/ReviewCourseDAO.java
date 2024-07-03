package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.ReviewCourse;

import java.sql.SQLException;
import java.util.List;

public interface ReviewCourseDAO {
    //增
    public void addReviewCourse(ReviewCourse reviewcourse);

    //删
    public void deleteReviewCourse(String cno) throws SQLException;

    //改
    public void updateReviewCourse(ReviewCourse reviewcourse);

    //查
    ReviewCourse getReviewCourse(String cno);

    //查所有
    List<ReviewCourse> getAllReviewCourses();
}
