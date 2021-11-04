package com.greedy.minesweeper.view;

import javax.swing.*;

public class MinesweeperGamePage  extends JPanel{

    public MinesweeperGamePage(JFrame mf,String userid) {
        JPanel panel = this;

        this.setLayout(null);
        this.setBounds(0, 0, 595, 842);

        ChooTopButtonCount minecounter = new ChooTopButtonCount();

        minecounter.setSize(100,100);
        minecounter.setLocation(45, 30);

        JPanel smile = new ChooTopButtonSmile(mf, panel,userid);
        smile.setSize(100,100);
        smile.setLocation(248, 20);

        ChooTopButtonTimer timer = new ChooTopButtonTimer();
        timer.setSize(300,30);
        timer.setLocation(300, 30);
//		timer.setStop(false);

        JPanel gridPanel = new ChooGrid2(mf,userid, panel,minecounter);
        gridPanel.setSize(540,540);
        gridPanel.setLocation(16, 150);

        this.add(gridPanel);
        this.add(minecounter);
        this.add(smile);
        this.add(timer);
        this.setVisible(true);
    }
}
