package com.greedy.ranking;

import com.greedy.mainFrame.BackgroundPanel;
import com.greedy.mainFrame.ChangePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class mineRanking extends JPanel {
    private final JFrame mf;
    private final JPanel panel;
    //	private ArrayList list;
    private ArrayList talist;

    public mineRanking(JFrame mf) {
        this.mf = mf;
        this.panel = this;
        this.talist = new ArrayList();
        this.setLayout(null);
        this.setSize(595, 842);
        this.backbutton(this);
        this.minebutton(this);
        this.readAll(this);
        this.printRank(this);
        this.repaint();
        this.revalidate();
        this.BackgroundImage(this);
    }

    public void BackgroundImage(JPanel jpanel) {
        Image background = new ImageIcon("image/ranking/minesweeperranking.png").getImage().getScaledInstance(595, 842, 0);
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
        JButton button1 = new JButton("", back);
        button1.setLocation(435, 18);
        button1.setSize(143, 50);
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

    /*지뢰찾기 게임 랭킹 패널에서 바시바시게임 랭킹 패널로 가는 버튼  생성*/
    public void minebutton(JPanel jpanel) {
        /*바시랭킹으로 가는 이미지 주소 */
        ImageIcon back = new ImageIcon(new ImageIcon("image/ranking/basibasirankingicon.png").getImage().getScaledInstance(143, 50, 0));
        /* 바시랭킹으로 가는 버튼 생성*/
        JButton button2 = new JButton("", back);

        button2.setLocation(50, 100);
        button2.setSize(143, 50);
        jpanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                basibasiRanking bg = new basibasiRanking(mf);
                ChangePanel cp = new ChangePanel(mf, jpanel);
                cp.changePanel(mf, panel, bg);
            }
        });
    }

    public void readAll(JPanel jpanel) {
        DataInputStream din = null;
        ArrayList list = null;

        try {
            list = new ArrayList();
            din = new DataInputStream(new FileInputStream("src/com/greedy/ranking/MinesweeperScroe.txt"));
            while (true) {
                String name = din.readUTF();
                int point = din.readInt();
                String[] date = din.readUTF().split("/_");

                System.out.println("name " + name);
                System.out.println("point" + point);
                System.out.println("date[0]" + date[0]);
                System.out.println("date[1]" + date[1]);
                list.add(name + "       " + point + "        " + date[0]);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("파일 읽기 완료! ");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (din != null) {
                try {
                    din.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        talist = list;
    }

    public void printRank(JPanel panel) {
        JPanel ranklist = new JPanel();
        ranklist.setLocation(0, 200);
        ranklist.setSize(595, 400);
        ranklist.setLayout(null);

        System.out.println("talist : " + talist);
        JLabel[] ta = new JLabel[talist.size()];
        System.out.println("talist Size: " + talist.size());
        JLabel col = new JLabel("이름      클리어 시간(초)     날짜");
        col.setSize(595, 50);
        col.setLocation(0, 0);
        ranklist.add(col);

        for (int i = 0; i < talist.size(); i++) {
            String line = (String) talist.get(i);
            System.out.println("line : " + line);

            ta[i] = new JLabel(line);
            ta[i].setSize(595, 50);
            ta[i].setLocation(0, 50 * (i + 2));
            try {
                //create the font to use. Specify the size!
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/com/greedy/font/DOSMyungjo.ttf")).deriveFont(30f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(customFont);
                ta[i].setFont(customFont);
                col.setFont(customFont);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (FontFormatException e) {
                e.printStackTrace();
            }
            ranklist.setBackground(new Color(0, 0, 0, 0));
            ranklist.add(ta[i]);
            if (i >= 9) {
                break;
            }
        }
        panel.add(ranklist);
    }
}
