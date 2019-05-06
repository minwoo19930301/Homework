package oopCalculator;
import javax.swing.*;
/**
 * NewCalculator
 */
public class Calculator extends JPanel{
    private String oldNum="0";                          //initialize start as 0
    private String newNum="";                               
    private String acc="";
    private JTextField text;                            //the text shown

    public Calculator(){
        this.add(text=new JTextField(14));
        text.setText(oldNum);
        this.add(new PadPanel(this));
    }//end constructor

    public String getOldNum(){                              //getters and setters
        return oldNum;
    }
    public String getNewNum(){
        return newNum;
    }

    public String getAcc(){
        return acc;
    }

    public void setOldNum(String s){
        oldNum=s;
    }
    public void setNewNum(String s){
        newNum=s;
    }
    public void setAcc(String s){
        acc=s;
    }
    public void setJText(String s){
        text.setText(s);
    }



}//end Calculator