package com.greedy.minesweeper.view;

import com.greedy.mainFrame.BackgroundPanel;
import com.greedy.mainFrame.ChangePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperPanel extends JPanel {

    private Image introBackground;
    private Image startButton;
    private Image backButton;
    private final JPanel panel;

    public MinesweeperPanel(JFrame mf,String userid) {
        this.panel = this;

        /* 패널 사이즈 지정 */
        this.setSize(595, 842);
        this.setLayout(null);

        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setSize(595, 842);
        /* 패널 백그라운드 이미지 지정 */
        Image introBackground = new ImageIcon(
                "image/minesweeper/mainwall.png").getImage();
        JLabel background = new JLabel(new ImageIcon(introBackground));
        background.setSize(595, 842);

        System.out.println("마인스위퍼의 닉네임: " + userid);
        /* 시작하기 버튼 */
        JButton start = new JButton("시작하기");
        start.setSize(100, 50);
        start.setLocation(250, 600);
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" 당신의 닉네임 :" + userid);
                ChangePanel.changePanel(mf, panel, new MinesweeperGamePage(mf,userid));
            }
        });

        /* 종료 버튼 */
        JButton back = new JButton("종료");
        back.setSize(100, 50);
        back.setLocation(250, 670);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePanel.changePanel(mf, panel, new BackgroundPanel(mf));
            }
        });

        /* 패널에 추가 */
        jpanel.add(start);
        jpanel.add(back);
        jpanel.add(background);
        this.add(jpanel);
        this.setVisible(true);
    }
}
