package netTest;
import java.lang.*;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("top o' the stack: 1");
    }

    public static void main(String[] args) {
        Runnable threadjob = new MyRunnable();
        Thread myThread = new Thread(threadjob);
        myThread.start();
        System.out.println("back in main");
    }
}