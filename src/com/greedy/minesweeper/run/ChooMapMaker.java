package com.greedy.minesweeper.run;

import javax.swing.*;
import java.awt.*;

public class ChooMapMaker{
    private String[][] map;
    private final int row = 9;
    private final int col = 9;
    private ImageIcon[][] numberMap;
    Image flag = new ImageIcon("image/minesweeper/mineimage/flag.png").getImage().getScaledInstance(60, 60, 0);
    Image Num0 = new ImageIcon("image/minesweeper/mineimage/blank.png").getImage().getScaledInstance(60, 60, 0);
    Image Num1 = new ImageIcon("image/minesweeper/mineimage/1.png").getImage().getScaledInstance(60, 60, 0);
    Image Num2 = new ImageIcon("image/minesweeper/mineimage/2.png").getImage().getScaledInstance(60, 60, 0);
    Image Num3 = new ImageIcon("image/minesweeper/mineimage/3.png").getImage().getScaledInstance(60, 60, 0);
    Image Num4 = new ImageIcon("image/minesweeper/mineimage/4.png").getImage().getScaledInstance(60, 60, 0);
    Image Num5 = new ImageIcon("image/minesweeper/mineimage/5.png").getImage().getScaledInstance(60, 60, 0);
    Image Num6 = new ImageIcon("image/minesweeper/mineimage/6.png").getImage().getScaledInstance(60, 60, 0);
    Image Num7 = new ImageIcon("image/minesweeper/mineimage/7.png").getImage().getScaledInstance(60, 60, 0);
    Image Num8 = new ImageIcon("image/minesweeper/mineimage/8.png").getImage().getScaledInstance(60, 60, 0);
    Image mineImg = new ImageIcon("image/minesweeper/mineimage/mine.png").getImage().getScaledInstance(60, 60, 0);
    private final ImageIcon boom;
    private final ImageIcon blank;
    private final ImageIcon picked;

    public ChooMapMaker() {
        this.map = new String[this.row][this.col];
        this.boom = new ImageIcon(mineImg);
        this.blank = new ImageIcon(Num0);
        this.picked = new ImageIcon(flag);
        this.MapLayout();
        this.MakeBlank();
        this.MakeMine();
        this.MakeNumber();
        this.MappingImg();
        System.out.println("지뢰 및 숫자 이미지 배열 배치완료 ");

    }

    /* 맵 생성*/
    public void MapLayout() {
        this.map = new String[row][col];
    }

    /* 맵에 초기값 넣기 */
    public void MakeBlank() {
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.col; j++) {
                this.map[i][j] = String.valueOf(0);
            }
        }
    }

    /* 맵에 지뢰 세팅 */
    public void MakeMine() {
        int mine = 10;
        for(int count = 0; count < mine;) {
            int i = (int)(Math.random() * (this.row-1));
            int j = (int)(Math.random() * (this.col-1));

            if(this.map[i][j].equals("0")){
                this.map[i][j] = "*";
                count++;
            }
        }
    }

    /* 숫자 배치 */
    public void MakeNumber() {
        int numberMineCount = 0;
        for(int k = 0; k < row; k++) {
            for(int n = 0; n <col; n++) {
                if(this.map[k][n].equals("*")) {
                    continue;
                } else {
                    for(int i = k-1; i <= k+1; i++) {
                        if(i >= 0 && i < row) {
                            for(int j = n-1; j <= n+1; j++) {
                                if(j >= 0 && j < col) {
                                    if(this.map[i][j].equals("*")) {
                                        numberMineCount++;
                                    }
                                }
                            }
                        }
                    }
                    this.map[k][n] = String.valueOf(numberMineCount);
                    numberMineCount = 0;
                }
            }
        }
    }

    public void MappingImg() {
        this.numberMap = new ImageIcon[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j <col; j++) {
                switch(map[i][j]) {
                    case "0" :
                        this.numberMap[i][j]= blank;
                        break;
                    case "1" :
                        this.numberMap[i][j]= new ImageIcon(Num1);
                        break;
                    case "2" :
                        this.numberMap[i][j]= new ImageIcon(Num2);
                        break;
                    case "3" :
                        this.numberMap[i][j]= new ImageIcon(Num3);
                        break;
                    case "4" :
                        this.numberMap[i][j]= new ImageIcon(Num4);
                        break;
                    case "5" :
                        this.numberMap[i][j]= new ImageIcon(Num5);
                        break;
                    case "6" :
                        this.numberMap[i][j]= new ImageIcon(Num6);
                        break;
                    case "7" :
                        this.numberMap[i][j]= new ImageIcon(Num7);
                        break;
                    case "8" :
                        this.numberMap[i][j]= new ImageIcon(Num8);
                    case "*" :
                        this.numberMap[i][j]= boom;
                        break;
                }
            }
        }
    }

    public ImageIcon[][] getMappingImg() {
        return this.numberMap;
    }

    public ImageIcon getBoom() {
        return boom;
    }
    public ImageIcon getBlank() {
        return blank;
    }
    public String[][] getMap(){
        return this.map;
    }
    public ImageIcon getflag(){
        return this.picked;
    }
}
