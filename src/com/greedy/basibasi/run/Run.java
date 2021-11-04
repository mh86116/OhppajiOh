package com.greedy.basibasi.run;

import java.util.Scanner;

public class Run {
    String[] block = new String[20];
    int count = 0;
    int count2 = 20;

    public void game() {
        for (int i = 0; i < block.length; i++) {
            int num = (int) (Math.random() * 3) + 1;
            if (num == 1) {
                block[i] = "빨강";
            } else if (num == 2) {
                block[i] = "파랑";
            } else if (num == 3) {
                block[i] = "초록";
            }
        }
    }

    public void setGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력 하세요 : ");
        String color = sc.nextLine();

        if (color.equals(block[count2])) {
            count++;
        } else {
            System.out.println("다른 번호를 입력하세요.");
            System.out.println("");
            setGame();
            return;
        }
        print();
    }

    public void print() {
        for (int i = 0; i < block.length - count; i++) {
            System.out.println(block[i]);
        }
        count2--;
        if (count2 < 0) {
            System.out.println("게임이 끝났습니다.");
            return;
        }
        setGame();
    }
}

