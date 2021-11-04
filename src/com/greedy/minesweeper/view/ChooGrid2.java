package com.greedy.minesweeper.view;

import com.greedy.mainFrame.ChangePanel;
import com.greedy.minesweeper.run.ChooMapMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ChooGrid2 extends JPanel {
    private final int row;
    private final int col;
    private int timerow;
    private int timecol;
    private final ImageIcon[][] blockMap ;
    private final ImageIcon boom;
    private final ImageIcon blank;
    private final ImageIcon picked;
    private ImageIcon singleblock;
    ImageIcon[][] numberMapImage;
    private final String[][] stringMap;
    private final JLabel[][] unclickedBlock;
    public boolean stop;
    public Thread t1;
    private final JFrame mf;
    private final String userId;
    private final JPanel panel;
    private static int checkMine = 10;
    public static int getCheckMine() {
        return checkMine;
    }

    public static void setCheckMine(int checkMine) {
        ChooGrid2.checkMine = checkMine;
    }

    private ChooTopButtonCount counter;
    private int AnswerCount = 0;

    public ChooGrid2(JFrame mf, String userId, JPanel panel, ChooTopButtonCount counter) {
        this.counter = counter;
        this.blockMap = new ImageIcon[9][9];
        this.unclickedBlock = new JLabel[9][9];
        this.row = 9;
        this.col = 9;
        this.mf = mf;
        this.panel = panel;
        this.userId= userId;
        this.t1 = ChooTopButtonTimer.t1;
        this.setSize(500,500);
        this.setLayout(new GridBagLayout());

        /* 배열에 블럭 이미지 넣기 */
        this.makeBlockImgArr();
        /* 정답지 배열 생성 후, 이미지 넣기 */
        ChooMapMaker mapMaker = new ChooMapMaker();
        this.numberMapImage = mapMaker.getMappingImg();
        this.stringMap =  mapMaker.getMap();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j <9; j++) {
                System.out.print(stringMap[i][j]);
            }
            System.out.println();
        }
        /* 폭탄 이미지 따로 배정 */
        this.boom = mapMaker.getBoom();
        /* 빈칸 이미지 따로 배정 */
        this.blank = mapMaker.getBlank();
        this.picked = mapMaker.getflag();
        System.out.println("게임그리드 닉네임 : "+ userId);


        /* 그리드 구현 */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.gridx = i;
                gbc.gridy = j;
                this.timerow = i;
                this.timecol = j;
                JLabel button = new JLabel(blockMap[i][j]);
                unclickedBlock[i][j] = button;
                this.ifclicked(button,i,j);
                this.repaint();
                this.revalidate();
                this.add(button,gbc);
            }
        }
        this.setVisible(true);
    }

    public void ifclicked(JLabel button, int i , int j) {
        ImageIcon newImage = this.numberMapImage[timecol][timerow];
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    /* 왼쪽클릭*/
                    if(newImage.equals(blank)) {
                        checkBlank(i,j,button);
                    } else if(newImage.equals(boom)) {
                        button.setIcon(newImage);
                        t1.interrupt();
                        gameOver(panel);
                        return;
                    } else {
                        button.setIcon(newImage);
                    }
                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    /* 오른쪽 클릭*/
                    if(button.getIcon().equals(singleblock)) {

                        button.setIcon(picked);
                        checkMine --;
                        System.out.println("checkMine : " + checkMine);
                        counter.setCheckMine(checkMine);
                        counter.setRepaint();
                        if(checkAnswer(i,j)) {
                            t1.interrupt();
                            gameClear(panel);
                            checkMine = 10;
                        }
                    }else if(button.getIcon().equals(picked) ){
                        button.setIcon(singleblock);
                        checkMine ++;
                        System.out.println("checkMine : " + checkMine);
                        counter.setCheckMine(checkMine);
                        counter.setRepaint();
                    }
                }
            }
        });
    }

    public void makeBlockImgArr() {
        Image block = new ImageIcon("image/minesweeper/mineimage/block.png").getImage().getScaledInstance(60, 60, 0);
        this.singleblock = new ImageIcon(block);
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.blockMap[i][j] = this.singleblock;
            }
        }
    }

    public void checkBlank(int i, int j, JLabel button) {
        for(int col = j-1; col <= j+1; col++) {
            if(col >= 0 && col <9) {
                for(int row = i-1; row <= i+1; row++) {
                    if((row >= 0 && row <9)) {
                        if(stringMap[col][row].equals("0")) {
                            unclickedBlock[row][col].setIcon(blank);
                            stringMap[col][row] = "opened";
                            checkBlank(row,col,button);
                        } else if(stringMap[col][row].equals("*")) {
                            stringMap[col][row] = "opened";
                        } else if(0 < Integer.parseInt(stringMap[col][row]) ) {
                            unclickedBlock[row][col].setIcon(numberMapImage[col][row]);
                            stringMap[col][row] = "opened";
                        }
                    }
                }
            }
        }
    }

    public void gameOver(JPanel panel) {
        String[] options = new String[2];
        options[0] = new String("예");
        options[1] = new String("처음으로");
        int gameoverpopup = JOptionPane.showOptionDialog(mf, "다시 시작하겠습니까? "," GameOver", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
        if(gameoverpopup == 0) {
            gameClear(panel);
        }else if(gameoverpopup == 1) {
            ChangePanel.changePanel(mf,panel, new MinesweeperPanel(mf,userId));
            this.repaint();
            this.revalidate();
        }
    }

    public void gameClear(JPanel panel) {
        String[] options = new String[2];
        options[0] = new String("랭킹 등록");
        options[1] = new String("다시하기");
        int gameoverpopup = JOptionPane.showOptionDialog(mf, "게임 클리어!! \n" + "닉네임 : "+userId+"\n"+"클리어 시간 : "," GameClear", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
        int cleartime = Timer.getTime();
        if(gameoverpopup == 0) {
            new ChooFileOutput(userId);
        }else if(gameoverpopup == 1) {
            ChangePanel.changePanel(mf,panel, new MinesweeperPanel(mf,userId));
            this.repaint();
            this.revalidate();
        }
    }

    public void clearCheck() {
        for(int i = 0; i <9; i++) {
            for(int j=0; j<9; j++) {
                ImageIcon answerblock = this.numberMapImage[j][i];
                unclickedBlock[i][j].setIcon(answerblock);
            }
        }
    }

    public boolean checkAnswer(int i,int j) {
        if(Objects.equals(stringMap[j][i], "*")) {
            AnswerCount ++;
            System.out.println("찾은 지뢰 갯수 : " + AnswerCount);
        }else if(!Objects.equals(stringMap[j][i], "*")) {
            System.out.println("찾은 지뢰 갯수 : " + AnswerCount);
            if(AnswerCount < 0) {
                AnswerCount = 0;
            }
        }
        return AnswerCount == 10 && checkMine == 0;
    }
}