package com.greedy.basibasi.practice.dalma.view;

import javax.swing.*;

public class ChangePanel {
    private JFrame mf;
    private JPanel panel;

    public ChangePanel(JFrame mf, JPanel panel) {
        this.mf = mf;
        this.panel = panel;
    }

    public void replacePanel(JPanel changePanel) {
        mf.remove(panel);
        mf.add(changePanel);
        mf.repaint();
    }

    public void resetPanel() {
        System.out.println();
        mf.remove(panel);
        mf.add(panel);
        mf.repaint();
    }

    public void replaceRankPanel(JPanel changePanel) {
        mf.remove(panel);
        mf.add(changePanel);
        mf.repaint();
    }
}
