/**
 * Trainer
 */
public class Trainer {
    public Pokemon poke;
    public String name;

    public void getPokemon(Pokemon p){
        poke=p;
    }

    public void giveRareCandies(int can){
        for (int i=0; i<can;i++){
            poke.levelUp();
        }
    }
}