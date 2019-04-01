/**
 * PokemonLauncher
 */
public class PokemonLauncher {
    public static void main(String[] args) {

    //make the objects first
    Trainer ash = new Trainer();
    Pokemon charm = new Charmander(5, "n341m");
    /*
    Charizard chari = new Charizard();
    System.out.println(charm+""+chari);
    charm=(Charmander)chari;
    System.out.println(charm+""+chari);
    */
    
    ash.getPokemon(charm);
    System.out.println(ash.poke.id+" "+ash.poke.attack);
    ash.poke.cry();
    ash.poke=ash.poke.evolve();
    ash.giveRareCandies(77);
    System.out.println(ash.poke.id+" "+ash.poke.attack);
    ash.poke.cry();
    

        
    }
    
}