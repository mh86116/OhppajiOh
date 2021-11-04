package com.greedy.minesweeper.view;

import com.greedy.mainFrame.ChangePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooTopButtonSmile extends JPanel {
    private JFrame mf;
    private JPanel panel;
    private JButton smile;
    private String userId;

    public ChooTopButtonSmile(JFrame mf, JPanel panel, String userId) {
        this.mf = mf;
        this.panel = panel;
        this.userId = userId;
        this.setLayout(null);
        this.setVisible(true);

        Image icon = new ImageIcon("image/minesweeper/smile.png").getImage().getScaledInstance(50, 50, 0);
        JButton smile = new JButton(new ImageIcon(icon));

        smile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangePanel.changePanel(mf,panel, new MinesweeperGamePage(mf,userId));
            }
        });
        smile.setSize(50, 50);
        smile.setLocation(0, 0);
        smile.setVisible(true);
        this.add(smile);
    }
}
