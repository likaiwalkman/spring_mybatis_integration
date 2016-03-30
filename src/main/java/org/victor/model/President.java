package org.victor.model;

import java.util.Date;

public class President {
    private String lastName;

    private String firstName;

    private String suffix;

    private String city;

    private String state;

    private Date birth;

    private Date death;

    public President(String lastName, String firstName, String suffix, String city, String state, Date birth, Date death) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.suffix = suffix;
        this.city = city;
        this.state = state;
        this.birth = birth;
        this.death = death;
    }

    public President() {
        super();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }
}