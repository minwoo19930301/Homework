/**
 * Charmander
 */
public class Charmander extends Pokemon{

    //just for the test
    public Charmander(){
        attack="scratch";
    }
    //if caught or adopted
    public Charmander(int _level, String _id){
        attack="scratch";
        id=_id;
        level=_level;
    }

    public void learn(int level){
        if (level==5)
            attack="ember";
        if (level==28)
            attack="firefang";
    }

    public Charizard evolve() {
        Charizard cha = new Charizard(this);
        System.out.println("Evolved to Charizard");
        return cha;
    }

    public void cry(){
        System.out.println("Char-mander~!");
    }

}