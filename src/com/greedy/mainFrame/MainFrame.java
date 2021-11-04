package com.greedy.mainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame{

    public MainFrame()	{

        this.setSize(595, 842);
        this.setLayout(null);
        this.add(new BackgroundPanel(this),"Center");

        this.setTitle("오빠지오 미니게임");

        try {
            this.setIconImage(ImageIO.read(new File("image/mainpage/mainFrameIcon.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

