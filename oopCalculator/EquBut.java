package oopCalculator;
import java.awt.event.*;
public class EquBut extends CalBut{
    public EquBut(String _val, PadPanel _pan){         //cannot inherit super class constructors
        super(_val,_pan);                    //use super(parameter) to do the same as super class constructor
    }
    @Override
    public void actionPerformed(ActionEvent e){
       operate();
    }
    
    public void operate(){
        double result=0;
        switch (pan.getAcc()){
            case "+": result = Double.parseDouble(pan.getOldNum())+Double.parseDouble(pan.getNewNum());
                  break;
            case "-": result = Double.parseDouble(pan.getOldNum())-Double.parseDouble(pan.getNewNum());
                  break;
            case "*": result = Double.parseDouble(pan.getOldNum())*Double.parseDouble(pan.getNewNum());
                  break;
            case "/": result = Double.parseDouble(pan.getOldNum())/Double.parseDouble(pan.getNewNum());
                  break;
            default:
        }
        
        if (result==(int)result){
            pan.setOldNum(String.valueOf((int)result));
        }
        else{
            pan.setOldNum(String.valueOf(result));
        }
        pan.setText(pan.getOldNum());
        pan.setNewNum("");
    }

    

}