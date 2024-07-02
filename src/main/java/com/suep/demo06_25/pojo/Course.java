package com.suep.demo06_25.pojo;

public class Course {
    private String cno;
   private String name;
   private String location;
   private String day;
   private int credit;

    public Course(String cno, String name, String location, String day, int credit) {
        this.cno = cno;
        this.name = name;
        this.location = location;
        this.day = day;
        this.credit = credit;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
