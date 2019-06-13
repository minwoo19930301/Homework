import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    
    ArrayList<PrintWriter> clientOutputStreams = new ArrayList<PrintWriter>();//client들의 outputstream들을 모아서 보관하는 ArrayList

    public static void main(String[] args) {
        Server server = new Server();//**
        server.go();
    }

    public void go() {
        ServerSocket serverSock;
        Socket clientSocket;
        int count = 0;
        

        try {
            //1. create serverSocket 
            serverSock = new ServerSocket(8738);

            while(count <= 30) {
                clientSocket = serverSock.accept();//serversocket에 
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());//해당 클라이언트에 쓸 수 있는 writer
                System.out.println(writer);
                clientOutputStreams.add(writer);//writer를 ArrayList에 넣는다.

                Thread t = new Thread(new Receiver(clientSocket));//해당 클라이언트와 통신하는 thread를 생성한다.
                t.start();
                count++;
            }
            serverSock.close(); //close serverSocket
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public class Receiver implements Runnable {//Client들을 받아주는 스레드
        
        Socket sock;
        BufferedReader reader;

        public Receiver(Socket socket) {
            try {
                sock = socket;
                InputStreamReader in= new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(in);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    send_Msg(message);
                }  
            } catch(Exception ex) {
                ex.printStackTrace();
            }      
        }
    }


    public synchronized void send_Msg(String message) {

        try {
            for(int i=0 ; i<clientOutputStreams.size() ; i++) {
                PrintWriter writer = clientOutputStreams.get(i);
                writer.println(message);
                writer.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    

}