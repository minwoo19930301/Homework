package gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class smallCalcul implements ActionListener {
    private static String labelPrefix = "NUM OF BUTTON YOU CLICK: ";
    private int numClicks = 0;
    JLabel L = new JLabel (labelPrefix + "0");

    public void makeWindow (String title){
        // title line of window
        JFrame F = new JFrame (title);
        // make buttons
        JButton B1 = new JButton("B1");
        JButton B2 = new JButton("B2");
        JButton B3 = new JButton("B3");
        // add action lister to button
        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        // make a panel that contains buttons
        JPanel P1 = new JPanel();
        P1.add(B1);
        P1.add(B2);
        P1.add(B3);
        // add panel and label on frame    
        F.getContentPane().add(BorderLayout.NORTH, L);
        F.getContentPane().add(BorderLayout.SOUTH, P1);
        
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.setSize(200,200);
        //F.pack();
        F.setVisible(true);
    }

    public void actionPerformed (ActionEvent event) {
        L.setText(labelPrefix + ++numClicks);
    }

    public static void main (String[] args){
        smallCalcul C = new smallCalcul();
        C.makeWindow("THIS IS TITLE !");
    }

    

    

}