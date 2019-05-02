package testSuperClassReferenceGiving;
import javax.swing.*;
/**
 * SecondClass
 */
public class SecondClass extends JPanel{
    public SecondClass(FirstClass f){
        this.add(new ThirdClass(f,"0"));

    }
    
}