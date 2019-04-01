/**
 * Charmeleon
 */
public class Charizard extends Charmander{

    //if caught wild
    public Charizard(){
    }
    //if evolved
    public Charizard(Charmander c){
        attack=c.attack;
        level=c.level;
        id=c.id;
    }

    public void learn(int level){
        if (level==5)
            attack="ember";
        if (level==28)
            attack="fire fang";
        if (level==47)
            attack="flamethrower";
        if (level==77)
            attack="flare blitz";
    }

    public void cry(){
        System.out.println("Charizard---~~~");
    }
    //concrete method that Charizard only has - it could be used with Pokemon with wings 
    //it would have been better if I made an interface of flying pokemon with fly method for other flying pokemon too
    public void fly(){
        System.out.println("Fly to where?(transportation)");
    }
    
}