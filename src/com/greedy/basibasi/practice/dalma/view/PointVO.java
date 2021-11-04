package com.greedy.basibasi.practice.dalma.view;

public class PointVO implements java.io.Serializable {
    /* 포인트 적립 받기 위해 VO 생성 */
    private int point;

    public PointVO() {}

    public PointVO(int point) {
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "PointVO [ point = " + this.point + "]";
    }
}
