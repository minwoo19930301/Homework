package gui;
import javax.swing.*;
/**
 * Gui
 */
public class Gui {

    public static void main(String[] args) {
        //container
        JFrame frame = new JFrame("HelloWorldSwing");
        //component
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}