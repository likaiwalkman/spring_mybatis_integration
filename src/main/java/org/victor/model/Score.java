package org.victor.model;

public class Score extends ScoreKey {
    private Integer score;

    public Score(Integer eventId, Integer studentId, Integer score) {
        super(eventId, studentId);
        this.score = score;
    }

    public Score() {
        super();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}