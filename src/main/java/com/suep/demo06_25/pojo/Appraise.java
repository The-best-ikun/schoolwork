package com.suep.demo06_25.pojo;


import com.mysql.cj.result.BigDecimalValueFactory;
import java.math.BigDecimal;

public class Appraise {
  private String sno;
   private String tno;
   private BigDecimal grade;
   private String appraise;

    public  Appraise(String sno, String tno, BigDecimal grade, String appraise) {
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

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }
}
