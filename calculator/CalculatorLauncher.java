package calculator;
import javax.swing.*;
/* 
 * CalculatorLauncher
 */
public class CalculatorLauncher {

    public static void main(String[] args) {
    JFrame f = new JFrame("Calculator.exe");
    f.setSize(300,200);
    f.setLocationRelativeTo(null);
    f.add(new Calculator());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    }
}