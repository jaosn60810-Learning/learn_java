package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Game test");
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameJPanel jp = new GameJPanel();
        jf.add(jp);

        jf.setVisible(true);

        Timer t = new Timer(10, (ActionEvent e) -> {
            jp.move();
        });
        t.start();
        Timer t2 = new Timer(10, (ActionEvent e) -> {
            jf.repaint();
        });
        t2.start();
    }
}
