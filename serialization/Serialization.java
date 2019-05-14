
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.ObjectInputStream;
/**
 * Serialization
 */
public class Serialization implements Serializable{

    public static void main(String[] args) throws IOException {
        Student s = new Student(3,"Minwoo");
        Student s2 = new Student(34,"Ho");

        //serializing s, s2
        try {
            FileOutputStream f = new FileOutputStream("MyName.ser");
            ObjectOutputStream os = new ObjectOutputStream(f);
            os.writeObject(s);
            os.writeObject(s2);
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try{
        //deserializing s, s2
        FileInputStream fileStream = new FileInputStream("MyName.ser");
        ObjectInputStream os2 = new ObjectInputStream(fileStream);
        Object one = os2.readObject();
        Object two = os2.readObject();
        Student minwoo = (Student)one;
        Student ho = (Student)two;
        System.out.println(minwoo.id);
        os2.close();
        } catch (Exception e){
            System.out.println("error");
        }
        
    }
}