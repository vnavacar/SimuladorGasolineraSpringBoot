package com.example.main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.Border;




public class GUI {
    private static JFrame frame;
    private static JPanel panel =new JPanel();
    private static ArrayList<JButton> botones;
    private static JScrollPane scrollPane;
    private int numSurtidores;

    public GUI(int numSurtidores){
        this.numSurtidores = numSurtidores;

        frame = new JFrame("Gasolinera");

        //frame.setSize(500, 500);
        frame.setBounds(400, 200, 500, 500);
        frame.add(scrollPane, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(numSurtidores, 1));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setColorRed(int surtidor, String text){
        botones.get(surtidor).setText("Surtidor "+surtidor+" "+text);
        botones.get(surtidor).setBackground(Color.RED);
    }
}
