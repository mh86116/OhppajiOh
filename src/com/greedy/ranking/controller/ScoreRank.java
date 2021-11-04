package com.greedy.ranking.controller;

import com.greedy.ranking.model.vo.Score;

import java.util.Comparator;

public class ScoreRank implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Score s1 = (Score) o1;
        Score s2 = (Score) o2;

        int result = 0;

        if(s1.getPoint() == s2.getPoint()){
            result = 0;
        }
        if(s1.getPoint() > s2.getPoint()){
            result = -1;
        }
        if(s1.getPoint() < s2.getPoint()){
            result = 1;
        }
        return result;
    }
}
