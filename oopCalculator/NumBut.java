package oopCalculator;
import java.awt.event.*;
public class NumBut extends CalBut{     
                                        
    public NumBut(String _val, PadPanel _pan){         //cannot inherit super class constructors
        super(_val,_pan);                    //use super(parameter) to do the same as super class constructor
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if ((pan.getNewNum()=="") && (getVal()=="0")){ //do nothing if first digit of newNum is typed 0
        }
        else{                                   
            pan.setNewNum(pan.getNewNum() + getVal());
            pan.setText(pan.getNewNum());
        }
    }
}