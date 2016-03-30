package org.victor.model;

public class Student {
    private Integer studentId;

    private String name;

    private String sex;

    public Student(Integer studentId, String name, String sex) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}