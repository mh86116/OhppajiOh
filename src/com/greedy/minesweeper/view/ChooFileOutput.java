package com.greedy.minesweeper.view;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ChooFileOutput {
    String userid;
    int time;

    public ChooFileOutput(String userid) {
        this.userid = userid;
        time = Timer.getTime();

        DataOutputStream dout = null;
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int mili = cal.get(Calendar.MILLISECOND);
        System.out.println(month + date + hour + minute+ second + mili);
        System.out.println("게임 정보 출력 _ 닉네임 : " + userid);
        System.out.println("게임 정보 출력 _ 플레이타임 :  " + time);
        System.out.println("게임 정보 출력 _ 게임플레이 날짜 :"  + month + date + hour + minute+ second + mili);
        try {
            dout = new DataOutputStream(
                    new FileOutputStream("src/com/greedy/ranking/MinesweeperScroe.txt",true));
            dout.writeUTF(userid);
            dout.writeInt(time);
            dout.writeUTF(month + "/" + date + "/_" + hour +":" + minute+":" +second + ":"+mili);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (dout != null) {
                try {
                    dout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}