package com.greedy.basibasi.practice.dalma.view;

import com.greedy.mainFrame.BackgroundPanel;
import com.greedy.ranking.basibasiRanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameOver extends JPanel {

    private final JPanel panel;
    private int point;
    private String userId;

    /* 게임 오버 패널 생성 */
    public GameOver(JFrame mf) throws IOException {
        panel = this;
        this.setLayout(null);
        this.setSize(595, 842);
        this.userId = userId;

        System.out.println("game over 페이지 진입");
        new FileOutput(userId);

        JLabel label = new JLabel(new ImageIcon(new ImageIcon("image/game.PNG").getImage().getScaledInstance(595, 842, 0)));
        label.setBounds(0, 0, 595, 842);

        /* 랭킹 조회 버튼 생성 */
        JButton bt1 = new JButton("랭킹조회");
        bt1.setBorderPainted(false);
        bt1.setContentAreaFilled(false);
        bt1.setFocusPainted(false);
        bt1.setBounds(30, 440, 250, 150);
        bt1.setForeground(Color.WHITE);
        bt1.setFont(new Font("궁서", Font.BOLD, 50));

        /* 메인화면 버튼 생성 */
        JButton bt2 = new JButton("메인화면");
        bt2.setBorderPainted(false);
        bt2.setContentAreaFilled(false);
        bt2.setFocusPainted(false);
        bt2.setBounds(295, 440, 250, 150);
        bt2.setBackground(Color.green);
        bt2.setForeground(Color.WHITE);
        bt2.setFont(new Font("궁서", Font.BOLD, 50));

        /* 랭킹조회 버튼 액션 */
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePanel cp = new ChangePanel(mf, panel);
                basibasiRanking bbr = new basibasiRanking(mf);

                cp.replaceRankPanel(bbr);
            }
        });

        /* 메인화면 버튼 액션 */
        bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePanel cp = new ChangePanel(mf, panel);
                BackgroundPanel bp = new BackgroundPanel(mf);

                cp.replacePanel(bp);
            }
        });

        /* 버튼, 패널 표출 */
        this.add(bt1);
        this.add(bt2);
        this.add(label);
    }
}