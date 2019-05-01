package gui;
import javax.swing.*;
import java.awt.event.*;
/**
 * 
 * Gui3
 */
public class Gui3 implements ActionListener{
    String labelPrefix = "Number of button clicks.";
    int numClicks =0;
    JLabel label = new JLabel(labelPrefix+ "0        ");
    
    public void go (String title){
        //container
        JFrame frame = new JFrame(title);
        //compoment
        JButton button = new JButton("Click Here");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        label.setText(labelPrefix + ++numClicks);
    }
    public static void main(String[] args) {
        Gui3 gui = new Gui3();
        gui.go("Event handling");
    }
}