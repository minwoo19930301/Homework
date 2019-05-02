package testSuperClassReferenceGiving;
import javax.swing.*;
/**
 * Launcher
 */
public class Launcher {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator.exe");
        f.setSize(300,200);
        f.setLocationRelativeTo(null);
        f.add(new FirstClass());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        }
}