import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {

    ChatArea chatA;// chatting window
    ChatField textF;// text
    BufferedReader reader;// reading chain stream
    PrintWriter writer;// writing chain stream
    Socket sock;// socket

    public static void main(String[] args) {
        Client launcher = new Client();
    }


    public Client(){
        GUI_initialize();
    }

    public class Main_Frame extends JFrame {// 프레임

        private static final long serialVersionUID = 1L;

        Main_Frame() {
            super("Chat");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setBounds(300, 300, 600, 500);// set Bound to Frame
        }

    }
    
    public class ChatArea extends JTextArea {// 채팅이 표시되는 채팅창

        private static final long serialVersionUID = 1L;

        ChatArea() {
            super(15, 50);
            setLineWrap(true);
            setWrapStyleWord(true);
            setEditable(false);
        }
    }

    public class ChatScroll extends JScrollPane {// 스크롤러로 채팅창을 감싼다.

        private static final long serialVersionUID = 1L;

        ChatScroll(JTextArea textBox) {
            super(textBox);
        }
    }

    public class ChatField extends JTextField implements KeyListener{// 채팅을 입력하는 공간

        private static final long serialVersionUID = 1L;

        ChatField() {
            super(20);
            this.addKeyListener(this);
        }
        @Override
        public void keyPressed(KeyEvent e) {// 엔터 키를 누르면 채팅을 서버로 전송한다.
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                try {
                    writer.println(textF.getText());
                    writer.flush();
                    textF.setText("");
                    textF.requestFocus();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
           }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

    }

    public class SendButton extends JButton implements ActionListener {// 채팅을 전송하는 버튼

        private static final long serialVersionUID = 1L;

        SendButton() {
            super("Send");
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {// 버튼을 누르면 채팅을 서버로 전송한다.
            try {
                writer.println(textF.getText());
                writer.flush();
                textF.setText("");
                textF.requestFocus();
            } catch (Exception ex) {
                ex.printStackTrace();
                
            }
        }
    }


    public class Main_Panel extends JPanel {// 패널

        private static final long serialVersionUID = 1L;

        Main_Panel() {
            super();
        }
    }

    public class IncomingReader implements Runnable {//Runnable

        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    chatA.append(message + "\n"); 
                }  
            } catch(Exception ex) {
                ex.printStackTrace();
            }      
        }
    }

    public void GUI_initialize() {

        Main_Frame frame = new Main_Frame();
        Main_Panel panel = new Main_Panel();
        frame.getContentPane().add(panel);
        chatA = new ChatArea();
        ChatScroll scroller = new ChatScroll(chatA);
        textF = new ChatField();
        SendButton sendButton = new SendButton();
        make_Connection();
        panel.add(scroller);
        panel.add(textF);
        panel.add(sendButton);

        Thread readerThread = new Thread(new IncomingReader());//서버에서 새로운 채팅을 계속 읽어들이고 update하는 역할
        readerThread.start();

        frame.setVisible(true);

    }

    public void make_Connection() {
        try {
            sock = new Socket("127.0.0.1", 8738);// 서버 ip, 소켓 번호를 입력해서 서버와 연결한다.
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());//InputStreamReader와 BufferedReader 사이의 bridge역할
            reader = new BufferedReader(streamReader);//서버에서 읽어오는 역할
            writer = new PrintWriter(sock.getOutputStream());//서버에 입력하는역할
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}