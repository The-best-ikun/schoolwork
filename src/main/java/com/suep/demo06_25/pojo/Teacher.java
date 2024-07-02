package com.suep.demo06_25.pojo;
import java.util.Date;

public class Teacher {
    private String tno;
    private  String name;
    private int age;
    private String phone;
    private String dept;
    private String professional;
   private Date starttime;

    public Teacher(String tno, String name, int age, String phone, String dept, String professional, Date starttime) {
        this.tno = tno;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.dept = dept;
        this.professional = professional;
        this.starttime = starttime;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
}
