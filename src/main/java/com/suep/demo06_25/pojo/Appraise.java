package com.suep.demo06_25.pojo;


import java.math.BigDecimal;

public class Appraise { //评教
  private String sno;
   private String tno;
   private Double grade;
   private String appraise;

    public  Appraise(String sno, String tno, Double grade, String appraise) {
        this.sno = sno;
        this.tno = tno;
        this.grade = grade;
        this.appraise = appraise;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }
}
