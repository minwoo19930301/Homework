/**
 * PokemonLauncher
 */
public class PokemonTest {
    public static void main(String[] args) {
        
        //Test1
        Pokemon lizamon = new Charizard();
        lizamon.cry();
        //lizamon.fly();
        //Charizard chari = lizamon;
        ((Charizard)lizamon).fly();
        Charizard chari = (Charizard)lizamon;


        ///Test2
        Charmander firey = new Charmander();
        //((Charizard)firey).fly();
        //lizamon=(Charizard)firey;
        //chari=(Charizard)firey;

        //Test3 - call by reference ideal
        //casting the remote controler(reference variable) can be valued to another same type of controller
        chari.fly();
        chari.id="14e";
        System.out.println(lizamon.id);

    }
    
}