package com.greedy.ranking.controller;

import com.greedy.mainFrame.ChangePanel;
import com.greedy.mainFrame.RankPanel;
import com.greedy.ranking.model.dao.ScoreDao;

import javax.swing.*;
import java.util.ArrayList;

public class ScoreManager {
    private String userId;
    private ScoreDao sd = new ScoreDao();
    private JFrame mf;
    private JPanel panel;


    public ScoreManager(String userId, JFrame mf, JPanel panel){
        this.userId = userId;
        this.mf = mf;
        this.panel = panel;
    }

    public void saveScore(){
        System.out.println(userId);
//		System.out.println(GamePanel.point);
//		Score s = new Score(userId, GamePanel.point);

//		sd.insertScore(s);

        ArrayList list = sd.readAll();
        list.sort(new ScoreRank());

        //System.out.println(list);

        new ChangePanel(mf, panel).replaceRankPanel(new RankPanel(mf));



    }
}
