package netTest;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Chat
 */
public class Chat{
    JTextField text;
    JButton send;
    JPanel pan;
    public Chat(PrintWriter writer) {
        JFrame f = new JFrame("Chat.exe");
        f.setSize(300,100);
        f.setLocationRelativeTo(null);
        f.add(pan=new JPanel());
        pan.add(text=new JTextField(14));
        pan.add(send=new JButton("send"));
        send.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    writer.println(text.getText());
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //TODO: handle exception
                }    
            }

        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}