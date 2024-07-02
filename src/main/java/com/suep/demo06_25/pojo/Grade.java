package com.suep.demo06_25.pojo;

import java.math.BigDecimal;
import com.mysql.cj.result.BigDecimalValueFactory;

public class Grade {
    private String sno;
    private String tno;
    private String cno;
    private BigDecimal grade;

    public Grade(String sno, String tno, String cno, BigDecimal grade) {
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

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}
