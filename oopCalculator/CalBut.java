package oopCalculator;

import java.awt.event.*;
import javax.swing.*;
/**
 * CalBut
 */
public class CalBut extends JButton implements ActionListener{
    String val;
    PadPanel pan;
    CalBut(String _val, PadPanel _pan) {
        super(_val);
        val = _val;
        pan = _pan;
        this.addActionListener(this);
        pan.add(this);
    }
    public String getVal() {
        return val;
    }
    public void actionPerformed(ActionEvent e){} //empty for overriding
}//end CalBut
