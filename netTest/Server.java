package netTest;
import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[] args) {

        
        try{
            Socket sock= new Socket("127.0.0.1", 5000);
            System.out.println(sock);
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
            Chat chat = new Chat(writer);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        
        /*
        try{
            ServerSocket ss = new ServerSocket(4242);
            while(true){
                //get a socket connection
                Socket sock = serverSock.accept();
                //make socket for writer
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                //get message from method
                String advice = getAdvice();
                //send message
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }
        */
        
    }

}