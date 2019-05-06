package oopCalculator;
import java.awt.event.*;
public class CBut extends CalBut{
    public CBut(String _val, PadPanel _pan){         //cannot inherit super class constructors
        super(_val,_pan);                    //use super(parameter) to do the same as super class constructor
    }
    @Override
    public void actionPerformed(ActionEvent e){             //refresh back to first initiative values.. if I linked the frames too.. probably intiating a new Calculator could have been nicer
        pan.setOldNum("0");
        pan.setNewNum("");
        pan.setAcc("");;
        pan.setText(pan.getOldNum());
    }
}