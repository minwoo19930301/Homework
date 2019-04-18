package gui;
import javax.swing.*;

/**
 * Gui4
 */
public class Gui4 {
    public static void main(String[] args) {
            //container
            JFrame frame = new JFrame();
            //compoment
            JButton button = new JButton("Click Here");
           
            JPanel panel = new JPanel();
            frame.getContentPane().add(button);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,300);
            frame.setVisible(true);
            
    }
}