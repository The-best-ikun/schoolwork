package com.suep.demo06_25.pojo;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.util.Date;
public class ReviewCourse {
    private String cno;
    private String tno;
    private String name;
    private String location;
    private String day;
    private String time;
    private int credit;
    private Date committee;
    private  String state;

    public ReviewCourse(String cno, String tno, String name, String location, String day, String time, int credit, Date committee, String state) {
        this.cno = cno;
        this.tno = tno;
        this.name = name;
        this.location = location;
        this.day = day;
        this.time = time;
        this.credit = credit;
        this.committee = committee;
        this.state = state;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getCommittee() {
        return committee;
    }

    public void setCommittee(Date committee) {
        this.committee = committee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
