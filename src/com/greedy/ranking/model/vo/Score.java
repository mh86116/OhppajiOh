package com.greedy.ranking.model.vo;

import java.util.Date;

public class Score implements java.io.Serializable{
    private String userId;
    private int point;
    private Date date;

    public Score(){}

    public Score(String userId, int point) {
        this.userId = userId;
        this.point = point;
        this.date = new Date();
    }

    public void setUserId(String userId) {
        this.userId = userId;

    }
    public void setPoint(int point) {
        this.point = point;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }
    public int getPoint() {
        return point;
    }
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return this.userId + ", " + this.point + ", " + this.date;
    }
}
