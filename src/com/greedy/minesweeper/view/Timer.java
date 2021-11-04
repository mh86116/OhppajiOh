package com.greedy.minesweeper.view;

import javax.swing.*;

public class Timer extends Thread{
    private JPanel panel;
    private TimeCountPanel ledPanel;
    private boolean stop;
    private static int endtime;

    public Timer(JPanel panel/*, int stop*/) {
        /*this.stop = stop;*/
        this.panel = panel;
        this.ledPanel = new TimeCountPanel();
        this.stop = false;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        this.endtime = 0;
        ledPanel.setSize(200,200);
        panel.add(ledPanel);
        JLabel label1 = null;
        JLabel label2 = null;
        JLabel label3 = null;
        for(int i = 0; i <= 999; i++) {

            if(stop == false) {
                try {
                    ledPanel.splitNum(i);
                    label1 = ledPanel.henNumberShower();
                    label2 = ledPanel.tenNumberShower();
                    label3 = ledPanel.oneNumberShower();
                    this.sleep(1000);
                    join(1000);
                } catch (InterruptedException e) {
                    this.endtime = i;
                    break;
                } finally  {
                    panel.removeAll();
                    panel.repaint();
                    panel.revalidate();
                    panel.add(label1);
                    panel.add(label2);
                    panel.add(label3);
                }
            } else if (stop == true) {
                break;
            }
        }
    }

    public static int getTime() {
        return endtime;
    }
}
