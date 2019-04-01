//abstract superclass Animal
public abstract class Animal {
	//instance variables
	public int size;
	public String name;
	//common method of all Animals
	public void eat() {
		System.out.println(name+"is eating");
	}
	public void sleep() {
		System.out.println(name+":zzzZZZ");
	}
	public abstract void cry();
}
