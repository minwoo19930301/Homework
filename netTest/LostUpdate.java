package netTest;
import java.lang.*;
/**
 * LostUpdate
 */
public class LostUpdate implements Runnable {
    public int balance;
    @Override
    public void run() {
        for(int i=0; i<50; i++){
            increment();
            System.out.println("balance is" + balance);
        }
    }
    public synchronized void increment() {
        balance++;
    }
    public static void main(String[] args) {
        LostUpdate job = new LostUpdate();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
    
}