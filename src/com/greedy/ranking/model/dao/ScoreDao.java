package com.greedy.ranking.model.dao;

import com.greedy.ranking.model.vo.Score;

import java.io.*;
import java.util.ArrayList;

public class ScoreDao {
    public void insertScore(Score s) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/com/greedy/ranking/MinesweeperScore.txt", true));
            oos.writeObject(s);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList readAll() {
        ArrayList list = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/com/greedy/ranking/MinesweeperScore.txt");
            list = new ArrayList();
            while (true) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Score s = (Score) ois.readObject();
                list.add(s);
            }
        } catch (EOFException e) {
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
