package com.greedy.ranking;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MineRankBoard extends JPanel {
    private ArrayList talist;

    public MineRankBoard(ArrayList talist) {
        this.talist = talist;

        JTextArea ta = new JTextArea();

        for (int i = 0; i < talist.size(); i++) {
            String line = (String) talist.get(i);
            ta.append(line + "\n");
            if (i >= 9) {
                break;
            }
        }
        ta.setBounds(0, 200, 500, 800);

        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/com/greedy/font/DOSMyungjo.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            ta.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        ta.setBackground(new Color(0, 0, 0, 0));
        this.add(ta);
    }
}
