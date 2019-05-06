package oopCalculator;
import javax.swing.*;
/**
 * CalculatorLauncher
 */
public class CalculatorLauncher {

    public static void main(String[] args) {  //one launcher = one frame is what I designed... but more frames could have been made if I put frames in Calculator class...
        JFrame f = new JFrame("Calculator.exe");
        f.setSize(300,200);
        f.setLocationRelativeTo(null);
        f.add(new Calculator());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        }
}