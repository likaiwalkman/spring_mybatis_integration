package org.victor.model;

import java.util.Date;

public class GradeEvent {
    private Integer eventId;

    private Date date;

    private String category;

    public GradeEvent(Integer eventId, Date date, String category) {
        this.eventId = eventId;
        this.date = date;
        this.category = category;
    }

    public GradeEvent() {
        super();
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}