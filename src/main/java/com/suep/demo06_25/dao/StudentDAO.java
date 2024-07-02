package com.suep.demo06_25.dao;

import com.suep.demo06_25.pojo.Student;

import java.util.List;

public interface StudentDAO {
    // 添加学生
    void addStudent(Student student);

    // 删除学生
    void deleteStudent(int studentId);

    // 更新学生信息
    void updateStudent(Student student);

    // 根据学生ID查询学生
    Student getStudent(int studentId);

    // 获取所有学生列表
    List<Student> getAllStudents();


    // 根据院系查询学生
    List<Student> getStudentsByDepartment(String department);

    // 检查学生是否存在
    boolean studentExists(int studentId);

    // 获取学生总数
    int getStudentCount();
}
