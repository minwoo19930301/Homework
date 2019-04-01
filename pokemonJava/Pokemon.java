//abstract superclass Pokemon
public abstract class Pokemon {
	//instance variables
	public String id;
	public int level;
	public String attack;
	
	//common method
	public void levelUp(){
		level++;
		learn(level);
	}
	//common method but different in concrete
	public abstract void cry();
	public abstract void learn(int level);
	public abstract Pokemon evolve();

}
