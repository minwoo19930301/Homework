package gui;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator extends JFrame{
 JButton but1;
 JButton but2;
 JButton but3;
 JButton but4;
 JButton but5;
 JButton but6;
 JButton but7;
 JButton but8;
 JButton but9;
 JButton but0;
 JButton butc;
 JButton butP;
 JTextField result;
 
    public Calculator() {
     new JFrame("Calculator");
     JPanel p1 = new JPanel();
     p1.setLayout(new GridLayout(4, 3));
     p1.add(but7 = new JButton("7"));
        p1.add(but8 = new JButton("8"));
        p1.add(but9 = new JButton("9"));
        p1.add(but4 = new JButton("4"));
        p1.add(but5 = new JButton("5"));
        p1.add(but6 = new JButton("6"));
        p1.add(but1 = new JButton("1"));
        p1.add(but2 = new JButton("2"));
        p1.add(but3 = new JButton("3"));
        p1.add(butc = new JButton("0"));
        p1.add(butc = new JButton("c"));
        p1.add(butc = new JButton("."));
        
       
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(result = new JTextField(20));
        result.setEditable(false);
      
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
        
        add(p);
     }
    
    
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.pack();
        cal.setLocationRelativeTo(null);
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cal.setVisible(true);
    }
}