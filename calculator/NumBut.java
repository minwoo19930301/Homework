package calculator;
import javax.swing.*;
/**
 * NumBut
 */
public class NumBut extends JButton {
    private int num;

    NumBut(String _num) {
        super("" + Integer.parseInt(_num));
        num = Integer.parseInt(_num);
    }

    public int getNum() {
        return num;
    }

}