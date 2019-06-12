import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    
    ArrayList<PrintWriter> clientOutputStreams;//client들의 outputstream들을 모아서 보관하는 ArrayList

    public static void main(String[] args) {
        
        ServerSocket serverSock;
        Socket clientSocket;
        int count = 0;
        Thread thread[] = new Thread[10];
        Server server = new Server();

        try {
            //1. create serverSocket 
            serverSock = new ServerSocket(9999);

            while(count <= 30) {
                clientSocket = serverSock.accept();//클라이언트의 연결요청을 받는다.
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());//해당 클라이언트에 쓸 수 있는 writer
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
        
        Socket socket;
        DataInputStream in;
        String name;
        BufferedReader reader;
        Socket sock;

        public Receiver(Socket socket) {
            try {
                sock = socket;
                in= new DataInputStream(sock.getInputStream());
                
                reader = new BufferedReader(isReader);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    send(message);
                }  
            } catch(Exception ex) {
                ex.printStackTrace();
            }      
        }
    }


    public void tellEveryone(String message) {

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
