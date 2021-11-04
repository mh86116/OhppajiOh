package com.greedy.minesweeper.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TimeCountPanel extends JPanel{
    Image Num0 = new ImageIcon("image/minesweeper/number/0.png").getImage().getScaledInstance(13, 23, 0);
    Image Num1 = new ImageIcon("image/minesweeper/number/1.png").getImage().getScaledInstance(13, 23, 0);
    Image Num2 = new ImageIcon("image/minesweeper/number/2.png").getImage().getScaledInstance(13, 23, 0);
    Image Num3 = new ImageIcon("image/minesweeper/number/3.png").getImage().getScaledInstance(13, 23, 0);
    Image Num4 = new ImageIcon("image/minesweeper/number/4.png").getImage().getScaledInstance(13, 23, 0);
    Image Num5 = new ImageIcon("image/minesweeper/number/5.png").getImage().getScaledInstance(13, 23, 0);
    Image Num6 = new ImageIcon("image/minesweeper/number/6.png").getImage().getScaledInstance(13, 23, 0);
    Image Num7 = new ImageIcon("image/minesweeper/number/7.png").getImage().getScaledInstance(13, 23, 0);
    Image Num8 = new ImageIcon("image/minesweeper/number/8.png").getImage().getScaledInstance(13, 23, 0);
    Image Num9 = new ImageIcon("image/minesweeper/number/9.png").getImage().getScaledInstance(13, 23, 0);
    Image Numhyphen = new ImageIcon("image/minesweeper/number/-.png").getImage().getScaledInstance(13, 23, 0);
    ArrayList<Image> arrimg;
    ArrayList<Integer> numArr;
    int henNum = 0;
    int tenNum = 0;
    int oneNum = 0;

    public TimeCountPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setVisible(true);
        this.ArrayImageing();
    }

    public JLabel henNumberShower() {
        return new JLabel(new ImageIcon(arrimg.get(henNum)));
    }

    public JLabel tenNumberShower() {
        return new JLabel(new ImageIcon(arrimg.get(tenNum)));
    }

    public JLabel oneNumberShower() {
        return new JLabel(new ImageIcon(arrimg.get(oneNum)));
    }

    public void ArrayImageing() {
        this.arrimg = new ArrayList<Image>();
        arrimg.add(0,Num0);
        arrimg.add(1,Num1);
        arrimg.add(2,Num2);
        arrimg.add(3,Num3);
        arrimg.add(4,Num4);
        arrimg.add(5,Num5);
        arrimg.add(6,Num6);
        arrimg.add(7,Num7);
        arrimg.add(8,Num8);
        arrimg.add(9,Num9);
        arrimg.add(10,Numhyphen);
    }

    public void splitNum(int num) {
        this.henNum = num/100;
        this.tenNum = (num - (henNum*100))/10;
        this.oneNum = num - (henNum*100)- (tenNum*10);
    }
}
