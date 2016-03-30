package org.victor.model;

import java.util.Date;

public class AbsenceKey {
    private Integer studentId;

    private Date date;

    public AbsenceKey(Integer studentId, Date date) {
        this.studentId = studentId;
        this.date = date;
    }

    public AbsenceKey() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}