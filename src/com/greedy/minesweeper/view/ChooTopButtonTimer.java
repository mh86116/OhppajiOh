package com.greedy.minesweeper.view;

import javax.swing.*;
import java.awt.*;

public class ChooTopButtonTimer extends JPanel {
    private boolean stop;
    public static Thread t1;

    public ChooTopButtonTimer() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        t1 = new Timer(this);
        t1.setDaemon(true);
        t1.start();
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
