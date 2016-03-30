package org.victor.model;

public class ScoreKey {
    private Integer eventId;

    private Integer studentId;

    public ScoreKey(Integer eventId, Integer studentId) {
        this.eventId = eventId;
        this.studentId = studentId;
    }

    public ScoreKey() {
        super();
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}