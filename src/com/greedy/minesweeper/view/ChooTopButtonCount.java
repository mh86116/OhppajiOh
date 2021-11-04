package com.greedy.minesweeper.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChooTopButtonCount extends JPanel{

    private int checkMine = 10;
    private int henNum = 0;
    private int tenNum = 1;
    private int oneNum = 0;
    private ArrayList<ImageIcon> mclist;

    private final Image Num0 = new ImageIcon("image/minesweeper/number/0.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num1 = new ImageIcon("image/minesweeper/number/1.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num2 = new ImageIcon("image/minesweeper/number/2.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num3 = new ImageIcon("image/minesweeper/number/3.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num4 = new ImageIcon("image/minesweeper/number/4.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num5 = new ImageIcon("image/minesweeper/number/5.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num6 = new ImageIcon("image/minesweeper/number/6.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num7 = new ImageIcon("image/minesweeper/number/7.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num8 = new ImageIcon("image/minesweeper/number/8.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Num9 = new ImageIcon("image/minesweeper/number/9.png").getImage().getScaledInstance(13, 23, 0);
    private final Image Numhyphen = new ImageIcon("image/minesweeper/number/-.png").getImage().getScaledInstance(13, 23, 0);

    public ChooTopButtonCount() {
        this.setLayout(new FlowLayout());
        System.out.println("ButtonCount패널 의 지뢰갯수 : " + checkMine);
        this.mineCountImgList();
        this.add(new JLabel(mclist.get(henNum)));
        this.add(new JLabel(mclist.get(tenNum)));
        this.add(new JLabel(mclist.get(oneNum)));
        this.repaint();
        this.setVisible(true);
    }

    public void splitNum(int num) {
        if(num >= 0) {
            this.henNum = num/100;
            this.tenNum = (num - (henNum*100))/10;
            this.oneNum = num - (henNum*100)- (tenNum*10);
        }else if(num < 0) {
            this.henNum = 10;
            this.tenNum = Math.abs(num)/10;
            this.oneNum = Math.abs(num) - (tenNum*10);
        }else{
            this.henNum = 0;
            this.tenNum = 0;
            this.oneNum = 0;
        }
    }

    public void mineCountImgList() {
        mclist = new ArrayList();

        mclist.add(0,new ImageIcon(Num0));
        mclist.add(1,new ImageIcon(Num1));
        mclist.add(2,new ImageIcon(Num2));
        mclist.add(3,new ImageIcon(Num3));
        mclist.add(4,new ImageIcon(Num4));
        mclist.add(5,new ImageIcon(Num5));
        mclist.add(6,new ImageIcon(Num6));
        mclist.add(7,new ImageIcon(Num7));
        mclist.add(8,new ImageIcon(Num8));
        mclist.add(9,new ImageIcon(Num9));
        mclist.add(10,new ImageIcon(Numhyphen));
    }

    public void setCheckMine(int checkMine) {
        this.checkMine = checkMine;
    }

    public void setRepaint() {
        this.removeAll();
        this.splitNum(checkMine);
        this.add(new JLabel(mclist.get(henNum)));
        this.add(new JLabel(mclist.get(tenNum)));
        this.add(new JLabel(mclist.get(oneNum)));
        this.repaint();
        this.revalidate();
    }
}
