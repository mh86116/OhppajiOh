package com.greedy.basibasi.practice.dalma.main;

import com.greedy.basibasi.practice.dalma.view.ChangePanel;
import com.greedy.basibasi.practice.dalma.view.GameDalma;
import com.greedy.basibasi.practice.dalma.view.Timer;
import com.greedy.mainFrame.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPage extends JPanel {

    private final JPanel panel;
    private String userId;
    int point;

    public MainPage(JFrame mf , String userId) {
        this.userId = userId;
        this.setLayout(null);
        this.setSize(595,842);


        panel = this;


        JLabel label = new JLabel(new ImageIcon(new ImageIcon("image/back.PNG").getImage().getScaledInstance(590, 850, 0)));
        label.setBounds(0, 0, 595, 842);

        /* 시작버튼 생성 */
        JButton btn1 = new JButton("시작하기");
        btn1.setBounds(30, 500, 250, 150);
        btn1.setBorderPainted(false);
        btn1.setFocusPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("궁서", Font.BOLD, 50));

        /* 뒤로가기 버튼 생성 */
        JButton btn2 = new JButton("뒤로가기");
        btn2.setBounds(30, 600, 250, 150);
        btn2.setBorderPainted(false);
        btn2.setFocusPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("궁서", Font.BOLD, 50));

        /* 시작 버튼 액션 */
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ChangePanel cp = new ChangePanel(mf, panel);
                GameDalma gv = new GameDalma(point);
                Timer timer = new Timer(mf, gv);
                timer.start();

                cp.replacePanel(gv);
            }
        });

        /* 뒤로가기 버튼 액션 */
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePanel cp = new ChangePanel(mf, panel);
                BackgroundPanel bp = new BackgroundPanel(mf);
                cp.replacePanel(bp);
            }
        });

        /* 버튼, 패널 표출 */
        this.add(btn1);
        this.add(btn2);
        this.add(label);
    }

    public void setUserId(String userId){
        this.userId = userId;
        System.out.println(this.userId);
    }

    public String getUserId() { return userId; }
}

