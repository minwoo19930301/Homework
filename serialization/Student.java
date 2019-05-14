import java.io.Serializable;
/**
 * Student
 */
public class Student extends Person implements Serializable {
    int id;
    String name;

    Student(int n, String s){
        id=n;
        name=s;
    }
}