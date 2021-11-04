package com.greedy.basibasi.practice.dalma.view;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class FileOutput {
    String userId;
    int Point;

    public FileOutput(String userId) throws IOException {
        this.userId = userId;
        this.Point = new PointVO().getPoint();

        DataOutputStream dout = null;
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int mili = cal.get(Calendar.MILLISECOND);
        int time = month + date + hour + minute + second + mili;
        System.out.println(time);

        System.out.println("게임 정보 출력 - 닉네임 = " + userId);
        System.out.println("게임 정보 출력 - 플레이점수 = " + Point);
        System.out.println("게임 정보 출력 - 게임플레이 날짜 = " + time);

        try {
            dout = new DataOutputStream(new FileOutputStream("src/com/greedy/ranking/basibasiScore.txt", true));
            dout.writeInt(Point);
            dout.writeUTF(month + "/" + date + "/" + hour + "/" + minute + "/" + second + "/" + mili);
        } catch (IOException e) {
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
