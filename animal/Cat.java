//concrete cat that extends Feline, Animal, Object
public class Cat extends Feline{
	public Cat(int _size, String _name) {
		size=_size;
		name=_name;
	}
	//override Feline cry
	public void cry() {
		if(size<5) {
		System.out.println("Meow");
		}
		else{
			System.out.println("RRRR!R!!!!R!!R!R!");
		}
	}
}
