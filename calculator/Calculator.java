package calculator;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
/**
 * Calculator
 */
public class Calculator extends JPanel{
    public String oldNum="";
    public String newNum="";
    public String acc="";
    public static JTextField result;

    public Calculator(){
        this.add(result=new JTextField(16));
        this.add(new PadPanel());
    }
   
    /**
     * PadPanel
     */
    public class PadPanel extends JPanel{
        private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
        private JButton[] buttons={b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15};
        private String[] order={"7","8","9","/","4","5","6","*","1","2","3","-","c","0","=","+"};
        public PadPanel(){
            this.setLayout(new GridLayout(4,4));
            for(int i=0; i<order.length; i++){
                try{
                    int n=Integer.parseInt(order[i]);
                    buttons[i]=new NumBut(order[i]);
                    this.add(buttons[i]);
                    buttons[i].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            String n=e.getActionCommand();
                            if (acc!=""){
                                result.setText("");
                            }
                            result.setText(newNum+n);
                            newNum=newNum+n;
                        }
                    });
                }
                catch(NumberFormatException n){
                    this.add(buttons[i]=new JButton(order[i]));
                    if(order[i]=="c"){
                        buttons[i].addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                String n=e.getActionCommand();
                                result.setText("");
                                oldNum="";
                                newNum="";
                                acc="";
                            }
                        });
                    }
                    if(order[i]=="="){
                        buttons[i].addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                if (acc=="+"){
                                    double sum=Double.parseDouble(oldNum)+Double.parseDouble(newNum);
                                    String _sum;
                                    if ((int)sum==sum){
                                        _sum=String.valueOf((int)sum);
                                    }
                                    else{
                                        _sum=String.valueOf(sum);
                                    }
                                    result.setText(_sum);
                                    oldNum=_sum;
                                    newNum="";
                                }
                                if (acc=="-"){
                                    double gap=Double.parseDouble(oldNum)-Double.parseDouble(newNum);
                                    String _gap;
                                    if ((int)gap==gap){
                                        _gap=String.valueOf((int)gap);
                                    }
                                    else{
                                        _gap=String.valueOf(gap);
                                    }
                                    result.setText(_gap);
                                    oldNum=_gap;
                                    newNum="";    
                                }
                                if (acc=="*"){
                                    double mul=Double.parseDouble(oldNum)*Double.parseDouble(newNum);
                                    String _mul;
                                    if ((int)mul==mul){
                                        _mul=String.valueOf((int)mul);
                                    }
                                    else{
                                        _mul=String.valueOf(mul);
                                    }
                                    result.setText(_mul);
                                    oldNum=_mul;
                                    newNum="";
                                }
                                if (acc=="/"){
                                    double div=Double.parseDouble(oldNum)/Double.parseDouble(newNum);
                                    String _div;
                                    if ((int)div ==div){
                                        _div=String.valueOf((int)div);
                                    }
                                    else{
                                        _div=String.valueOf(div);
                                    }
                                    result.setText(_div);
                                    oldNum=_div;
                                    newNum="";
                                }
                            }
                        });
                    }

                    else{
                        buttons[i].addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                String n=e.getActionCommand();
                                if(oldNum==""){
                                    oldNum=newNum;
                                    newNum="";
                                    acc=n;    
                                }
                                else{
                                    acc=n;
                                }
                            }
                        });
                    }
            }
        }
     }
    
}
    
}