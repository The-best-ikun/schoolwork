package com.suep.demo06_25.pojo;


public class Grade {
    private String sno;
    private String tno;
    private String cno;
    private double grade;

    public Grade(String sno, String tno, String cno, double grade) {
        this.sno = sno;
        this.tno = tno;
        this.cno = cno;
        this.grade = grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
