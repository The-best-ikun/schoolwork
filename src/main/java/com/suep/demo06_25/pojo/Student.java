package com.suep.demo06_25.pojo;

import java.util.Date;

public class Student {
    private String sno;
    private String name;
    private String sex;
    private String age;
    private String major;
    private String phone;
    private String address;
    private String dept;
    private Date time;
    private byte[] picture;


    public Student(String sno, String name, String sex, String age, String major, String phone, String address, String dept, Date time, byte[] picture) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
        this.phone = phone;
        this.address = address;
        this.dept = dept;
        this.time = time;
        this.picture = picture;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
