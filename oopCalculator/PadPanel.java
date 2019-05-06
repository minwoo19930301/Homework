package oopCalculator;
import javax.swing.*;
import java.awt.GridLayout;
public class PadPanel extends JPanel{
        public Calculator cal;                 //reference variable for inner classes to access outer class instance variables
        private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;              
        private JButton[] buttons={b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15};  //array of buttons to serially make buttons and functions
        private String[] order={"7","8","9","/","4","5","6","*","1","2","3","-","c","0","=","+"};
        
        public PadPanel(Calculator _cal){
            cal=_cal;                       //link the object's reference to this object
            this.setLayout(new GridLayout(4,4));
            for(int i=0; i<order.length; i++){
                try{                                                        //if the String is a number make numbuttons
                    int n=Integer.parseInt(order[i]);
                    buttons[i]=new NumBut(order[i], this);
                }
                catch(NumberFormatException n){                             //if the String is not a number make operator buttons
                    switch (order[i]){
                        case "c": buttons[i]=new CBut(order[i],this);       //for clear
                                  break;
                        case "=": buttons[i]=new EquBut(order[i],this);     //for equal 
                                  break;
                        default: buttons[i] = new AccBut(order[i],this);    //for other +,-,*,/
                                  break;
                    }
                }
        }
    } //end constructor

    //getters and setters for Calculator
    public String getOldNum(){
        return cal.getOldNum();
    }
    public String getNewNum(){
        return cal.getNewNum();
    }

    public String getAcc(){
        return cal.getAcc();
    }

    public void setOldNum(String s){
        cal.setOldNum(s);
    }
    public void setNewNum(String s){
        cal.setNewNum(s);
    }
    public void setAcc(String s){
        cal.setAcc(s);
    }
    public void setText(String s){
        cal.setJText(s);
    }
}//end PadPanel