package com.greedy.mainFrame;

import com.greedy.ranking.basibasiRanking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RankPanel extends JPanel{
    private final JFrame mf;
    private final JPanel panel;
    private ArrayList list;
    /* 랭킹페이지로 넘어가기전 지뢰찾기와 바샤바샤를 선택하는 페널 */
    public RankPanel(JFrame mf){
        this.mf = mf;
        this.panel = this;
        this.setLayout(null);
        this.setSize(595, 842);
        /* 버튼을 위로 올리기 위해 순서 수정함 */
        this.basibasiStartButton(this);
        this.minsweeperStartButton(this);
        this.backButton(this);
        this.BackgroundImage(this);

    }

    public void BackgroundImage(JPanel jpanel) {
        Image background = new ImageIcon("image/backgroundrankingimage.png").getImage().getScaledInstance(595, 842, 0);
        JLabel label = new JLabel(new ImageIcon(background));

        label.setBounds(0, 0, 595, 842);
        label.setVisible(true);
        System.out.println("이미지 호출 ");

        jpanel.add(label);
    }

    public void basibasiStartButton(JPanel jpanel) {
        /*빠샤빠샤 이미지 주소 */
        ImageIcon basibasititle = new ImageIcon("image/mainpage/basibasi.png");

        /* 빠샤빠샤 버튼 생성*/
        JButton button2 = new JButton("",basibasititle );
        button2.setLocation(135, 500);
        button2.setSize(318, 78);
        jpanel.add(button2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //				basibasiranking rk = new basibasiranking(jpanel);
                ChangePanel.changePanel(mf, panel, new basibasiRanking(mf));

                //				cp.replaceRankPanel(rk);
            }
        });
        System.out.println("바시바시 버튼 호출11 ");
    }

    public void minsweeperStartButton(JPanel jpanel) {

        /* 지뢰찾기 이미지 주소 */
        ImageIcon minesweepertitle = new ImageIcon("image/mainpage/minsweeper.png");

        /* 지뢰찾기 게임 버튼 */
//        JButton button1 = new JButton("",minesweepertitle);
//        button1.setLocation(135, 350);
//        button1.setSize(318, 78);
//        jpanel.add(button1);
//
//        button1.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ChangePanel.changePanel(mf, panel, new mineranking(mf));
//            }
//        });
//        System.out.println("마인스위퍼 호출 ");
    }

    public void backButton(JPanel jpanel) {

        /*뒤로가기 이미지 주소 */
        ImageIcon back = new ImageIcon(new ImageIcon("image/backbuttonbig.png").getImage().getScaledInstance(318, 78, 0));
        /* 뒤로가기 버튼 생성*/
        JButton button1 = new JButton("", back);
        button1.setLocation(135, 650);
        button1.setSize(318, 78);
        jpanel.add(button1);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                BackgroundPanel bg = new BackgroundPanel(mf);
                ChangePanel cp = new ChangePanel(mf, jpanel);
                cp.changePanel(mf, panel, bg);

            }
        });
    }
    /* 필요없는 이미지 메소드 날림 */

}
