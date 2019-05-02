package testSuperClassReferenceGiving;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * ThirdClass
 */
public class ThirdClass extends JButton implements ActionListener{
    FirstClass first;
    String num;
    public ThirdClass(FirstClass f, String n){
        super("" + Integer.parseInt(n));
        num = n;
        first=f;
        this.addActionListener(this);
        }

    public void actionPerformed(ActionEvent e){
        first.result.setText(first.prefix+num);
    }

}

    
