package com.greedy.mainFrame;

import javax.swing.*;

public class ChangePanel {
    private JFrame mf;
    private JPanel panel;

    public static void changePanel(JFrame mf, JPanel op, JPanel np){
        mf.remove(op);
        mf.add(np);
        mf.repaint();
    }

    public ChangePanel(JFrame mf, JPanel panel) {
        this.mf = mf;
        this.panel = panel;
    }

    public void replaceRankPanel(JPanel changePanel){
        mf.remove(panel);
        mf.add(changePanel);
        mf.repaint();
    }

    public void noReplace(JPanel changeJPanel) {
        mf.removeAll();
        mf.add(panel);
        mf.repaint();
    }
}
