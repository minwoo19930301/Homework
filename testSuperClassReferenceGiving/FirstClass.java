package testSuperClassReferenceGiving;
import javax.swing.*;
/**
 * FirstClass
 */
public class FirstClass extends JPanel {
    public String prefix="";
    public static JTextField result;
    public FirstClass(){
        this.add(result=new JTextField(16));
        this.add(new SecondClass(this));
    }
}