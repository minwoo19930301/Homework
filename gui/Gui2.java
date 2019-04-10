package gui;
import javax.swing.*;
/**
 * Gui2
 */
public class Gui2 {

    public static void main(String[] args) {
        //container
        JFrame frame = new JFrame("ButtonSwing");
        //compoment
        JButton button = new JButton("Click Here");

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}