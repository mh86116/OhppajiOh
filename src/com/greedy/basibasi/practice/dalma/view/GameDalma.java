package com.greedy.basibasi.practice.dalma.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameDalma extends JPanel {
    /* 랜덤 번호 저장 배열 임의로 100개까지 줌 */
    private final int[] arrNo = new int[100];
    int count = 0;
    int Point;
    private final ArrayList<JLabel> inputs = new ArrayList<>();
    PointVO pv = new PointVO();

    /* 게임 패널 생성 */
    public GameDalma(int point) {
        this.setLayout(null);
        this.setBounds(0, 0, 595, 842);
        this.setBackground(Color.DARK_GRAY);
        this.Point = point;

        System.out.println("게임달마 페이지 진입");
        System.out.println(new PointVO());
        blockSet();
    }

    /* 랜덤 블록 이미지 ArrayList에 저장 */
    public void blockSet() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3) + 1;
            arrNo[i] = num;
            Image icon = new ImageIcon("image/" + num + "-color.png").getImage().getScaledInstance(100, 70, 0);
            JLabel input = new JLabel(new ImageIcon(icon));
            inputs.add(input);
        }
        /* 프린터로 이동 */
        print();
    }

    /* 버튼 생성 */
    public void buttonset() {
        System.out.println("버튼셋 도착 - 카운트 숫자 " + count);

        ImageIcon re = new ImageIcon("image/re.png");
        JButton bt1 = new JButton(re);
        bt1.setBorderPainted(false);
        bt1.setContentAreaFilled(false);
        bt1.setFocusPainted(false);
        bt1.setBounds(40, 580, 160, 150);
        bt1.setBackground(Color.red);

        ImageIcon bl = new ImageIcon("image/gr.png");
        JButton bt2 = new JButton(bl);
        bt2.setBorderPainted(false);
        bt2.setContentAreaFilled(false);
        bt2.setFocusPainted(false);
        bt2.setSize(160, 150);
        bt2.setLocation(220, 580);
        bt2.setBackground(Color.blue);

        ImageIcon gr = new ImageIcon("image/br.png");
        JButton bt3 = new JButton(gr);
        bt3.setBorderPainted(false);
        bt3.setContentAreaFilled(false);
        bt3.setFocusPainted(false);
        bt3.setSize(160, 150);
        bt3.setLocation(400, 580);
        bt3.setBackground(Color.green);

        this.add(bt1);
        this.add(bt2);
        this.add(bt3);

        pointLabel();
        /* 빨간 버튼 생성 액션 추가 */
        bt1.addActionListener(e -> {
            if (arrNo[count] == 1) {
                setgame();
            } else {
                Point -= 10;
                buttonset();
            }
        });
        /* 초록 버튼 생성 액션 추가 */
        bt2.addActionListener(e -> {
            if (arrNo[count] == 2) {
                setgame();
            } else {
                Point -= 10;
                buttonset();
            }
        });
        /* 파란 버튼 생성 액션 추가 */
        bt3.addActionListener(e -> {
            if (arrNo[count] == 3) {
                setgame();
            } else {
                Point -= 10;
                buttonset();
            }
        });
    }

    /* 생성된 블럭 제거, 포인트 누적 */
    public void setgame() {
        this.remove(inputs.remove(0));
        this.repaint();
        count++;
        Point += 50;
        pv.setPoint(this.Point);
        System.out.println("점수는 = " + this.Point);
        System.out.println("pv.toString() = " + pv.toString());
        print();
    }

    /* 패널에 블록 표현  */
    public void print() {
        int y = 400;
        for (JLabel input : inputs) {
            this.add(input);
            input.setBounds(100, y, 100, 70);
            y -= 75;
        }
        buttonset();
    }

    /* 포인트 글씨 생성 */
    public void pointLabel() {
        JTextField pointLabel = new JTextField("점수 : " + this.Point);
        pointLabel.setFont(new Font("궁서", Font.BOLD, 20));
        pointLabel.setForeground(Color.WHITE);
        pointLabel.setBackground(Color.DARK_GRAY);
        pointLabel.setBounds(400, 100, 140, 50);
        this.add(pointLabel);
    }
}