package com.greedy.ranking;

import com.greedy.mainFrame.BackgroundPanel;
import com.greedy.mainFrame.ChangePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class basibasiRanking extends JPanel{

    private final JFrame mf;
    private final JPanel panel;

    public basibasiRanking(JFrame mf){

        this.mf = mf;
        this.panel = this;
        this.setLayout(null);
        this.setSize(595, 842);
        this.backbutton(this);
        this.minebutton(this);
        this.printRank(this);
        this.BackgroundImage(this);
    }

    public void BackgroundImage(JPanel jpanel) {
        Image background = new ImageIcon("image/ranking/basibasiranking.png").getImage().getScaledInstance(595, 842, 0);
        JLabel label = new JLabel(new ImageIcon(background));
        label.setBounds(0, 0, 595, 842);
        label.setVisible(true);
        System.out.println("이미지 호출 ");
        jpanel.add(label);
    }

    public void backbutton(JPanel jpanel) {
        /*뒤로가기 이미지 주소 */
        ImageIcon back = new ImageIcon("image/ranking/backbutton.png");
        /* 뒤로가기 버튼 생성*/
        JButton button1 = new JButton("",back);
        button1.setLocation(430, 20);
        button1.setSize(143, 50);
        jpanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackgroundPanel bg = new BackgroundPanel(mf);
                ChangePanel.changePanel(mf, panel, bg);
            }
        });
    }
    /*바시바시 게임 랭킹 패널에서 지뢰찾기 게임 랭킹 패널로 가는 버튼  생성*/
    public void minebutton(JPanel jpanel) {
        /*마인랭킹으로 가는 이미지 주소 */
        ImageIcon back = new ImageIcon(new ImageIcon("image/ranking/mineirankingicon.png").getImage().getScaledInstance(143, 50, 0));
        /* 마인랭킹으로 가는 버튼 생성*/
        JButton button2 = new JButton("",back);
        button2.setLocation(50, 100);
        button2.setSize(143, 50);
        jpanel.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mineRanking bg = new mineRanking(mf);
                ChangePanel.changePanel(mf, panel, bg);
            }
        });
    }

    public void printRank(JPanel jpanel){
        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        System.out.println("텍스트패널");
        ta.append("업데이트중,,,");
//			for(int i = 0; i < list.size(); i++){
//				Score s = (Score) list.get(i);
//				ta.append((i+1) + "�� " + s.getPoint() + " ��    "+ s.getUserId() + "\n");
//				if(i >= 9){
//					break;
//				}
//			}
        ta.setBackground(new Color(0,0,0,0));
        ta.setBounds(50, 150, 500, 500);
        ta.setBorder(BorderFactory.createLineBorder(Color.black));
        ta.setFont(new Font("Sanscerif", Font.BOLD, 50));
        this.add(ta);
    }
}
