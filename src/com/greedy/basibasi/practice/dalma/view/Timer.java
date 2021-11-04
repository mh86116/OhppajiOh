package com.greedy.basibasi.practice.dalma.view;

import com.greedy.mainFrame.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Timer extends Thread {
    private final JFrame mf;
    private final JPanel panel;

    /* 시간 타이머 생성 */
    public Timer(JFrame mf, JPanel panel) {
        this.mf = mf;
        this.panel = panel;
    }

    @Override
    public void run() {
        JTextField label = new JTextField("남은 시간 = ");
        label.setBounds(400, 50, 140, 50);
        label.setFont(new Font("궁서", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.DARK_GRAY);
        panel.add(label);

        /* 제한 시간 생성 */
        for (int i = 0; i >= 0 ; i--) {
            try {
                Thread.sleep(10000);
                label.setText("남은 시간 : " + i);
                System.out.println("i = " + i);
                ChangePanel cp = new ChangePanel(mf, panel);
                GameOver go = new GameOver(mf);
                BackgroundPanel bp = new BackgroundPanel(mf);

                cp.replacePanel(go);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
