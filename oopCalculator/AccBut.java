package oopCalculator;
import java.awt.event.*;
public class AccBut extends EquBut{                 //this inherits from Equ to re-use the same method
    public AccBut(String _val, PadPanel _pan){         //cannot inherit super class constructors
        super(_val,_pan);                           //use super(parameter) to do the same as super class constructor
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (pan.getNewNum()!=""){ 
            if (pan.getAcc()!=""){
                operate();                              //re-use the equBut's operation method (inheritance)
            }else{
            pan.setOldNum(pan.getNewNum());
            pan.setNewNum("");
            }
        }
        pan.setAcc(getVal());
    }
}
