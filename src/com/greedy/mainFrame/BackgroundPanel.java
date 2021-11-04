package com.greedy.mainFrame;

import com.greedy.basibasi.practice.dalma.main.MainPage;
import com.greedy.minesweeper.view.MinesweeperPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundPanel extends JPanel {
    private JFrame mf;
    private JPanel panel;
    private String userId;

    public BackgroundPanel(JFrame mf) {
        this.mf = mf;
        this.panel = this;

        this.setLayout(null);
        this.setSize(595, 842);
        /* 버튼을 위로 올리기 위해 순서 변경함 */
//        this.minsweeperStartButton(this);
        this.basibasiStartbutton(this);
        this.rankingStartbutton(this);
        this.closebutton(this);
        this.BackgroundImage(this);
    }

    public void BackgroundImage(JPanel jpanel) {
        Image background = new ImageIcon("image/backgroundimage.png").getImage().getScaledInstance(595, 842, 0);
        JLabel label = new JLabel(new ImageIcon(background));
        label.setBounds(0, 0, 595, 842);
        label.setVisible(true);
        System.out.println("이미지 호출 ");

        jpanel.add(label);
    }

    public void minsweeperStartbutton(JPanel jpanel) {
        /* 지뢰찾기 닉네임 입력받는 팝업 */
        Dialog sd = new Dialog(mf, "지뢰찾기 닉네임 입력");
        sd.add(new JLabel("simple dialog test"));
        /* 지뢰찾기 이미지 주소 */
        ImageIcon minesweepertitle = new ImageIcon("image/mainpage/minsweeper.png");
        /* 지뢰찾기 게임 버튼 */
        JButton button1 = new JButton("", minesweepertitle);
        button1.setLocation(135, 350);
        button1.setSize(318, 78);
        jpanel.add(button1);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = JOptionPane.showInputDialog("닉네임을 입력하세요.");
                System.out.println(" 당신의 닉네임 :" + userId);
//				ChangePanel.changePanel(mf, panel, new MinesweeperPanel(mf,userId));
                if (userId == null || userId.equals("")) {
                    ChangePanel.changePanel(mf, panel, new BackgroundPanel(mf));
                } else {
                    ChangePanel.changePanel(mf, panel, new MinesweeperPanel(mf, userId));
                }
                /*닉네임 입력을 안받으면 안넘어 가게 하고 싶음*/
//				if(userId != null) {
//				ChangePanel.changePanel(mf, panel, new MinesweeperPanel());
//				} else {
//					ChangePanel.changePanel(mf, panel,new BackgroundPanel(mf));
//				}
                userId = null;
                {
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ChangePanel.changePanel(mf, panel, panel);
                        }
                    });
                }
                System.out.println("panel changed");
            }
        });
        System.out.println("마인스위퍼 호출 ");
    }

    public void basibasiStartbutton(JPanel jpanel) {
        /*빠샤빠샤 이미지 주소 */
        ImageIcon basibasititle = new ImageIcon("image/mainpage/basibasi.png");

        /* 빠샤빠샤 버튼 생성*/
        JButton button2 = new JButton("", basibasititle);
        button2.setLocation(135, 450);

        button2.setSize(318, 78);
        jpanel.add(button2);

        /*빠샤빠샤 닉네임 받는 팝업 */
        Dialog sd1 = new Dialog(mf, "빠샤빠샤 닉네임 입력");
        sd1.add(new JLabel("simple dialog test"));

        /*빠샤빠샤 버튼 클릭시 팝업 뜸*/
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userId = JOptionPane.showInputDialog("닉네임을 입력하세요.");
                System.out.println("당신의 닉네임" + userId);

//				ChangePanel.changePanel(mf, panel, new MainPage(mf,userId));
//				userId = null;
                /*닉네임 입력을 안받으면 안넘어 가게 하고 싶음*/

                if (userId == null || userId.equals("")) {
                    ChangePanel.changePanel(mf, panel, new BackgroundPanel(mf));
                } else {
                    ChangePanel.changePanel(mf, panel, new MainPage(mf, userId));
                }
                userId = null;
            }
        });
        System.out.println("바시바시 버튼 호출 ");
    }

    public void rankingStartbutton(JPanel jpanel) {
        /* 랭킹 이미지 주소 */
        ImageIcon basibasititle = new ImageIcon("image/mainpage/rankingbutton.png");

        /* 랭킹 버튼 생성*/
        JButton button2 = new JButton("", basibasititle);
        button2.setLocation(135, 550);
        button2.setSize(318, 78);
        jpanel.add(button2);

//		ChangePanel.changePanel(mf, op, new RankPanel(list));

        /* 랭킹 버튼 클릭시 팝업 뜸*/
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* 랭킹 버튼 클릭시 팝업뜨는 것 주석처리 */
//				String userId = JOptionPane.showInputDialog("닉네임을 입력하세요.");
//				System.out.println("당신의 닉네임" + userId);
                ChangePanel.changePanel(mf, panel, new RankPanel(mf));
            }
        });
        System.out.println("랭킹 버튼 호출 ");
    }

    public void closebutton(JPanel jpanel) {

        /* 랭킹 이미지 주소 */
        ImageIcon closebutton = new ImageIcon("image/closebutton.png");

        /* 랭킹 버튼 생성*/
        JButton button4 = new JButton("", closebutton);
        button4.setLocation(135, 650);
        button4.setSize(318, 78);
        jpanel.add(button4);

//		ChangePanel.changePanel(mf, op, new RankPanel(list));

        /* 랭킹 버튼 클릭시 팝업 뜸*/
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                /* 랭킹 버튼 클릭시 팝업뜨는 것 주석처리 */
//				String userId = JOptionPane.showInputDialog("닉네임을 입력하세요.");
//				System.out.println("당신의 닉네임" + userId);
                System.exit(0);
            }
        });
        System.out.println("랭킹 버튼 호출 ");
    }
}
