package animal;

//concrete Dog objects extends Canine-Animal-Object
public class Dog extends Canine{
	//dogs have owners usually, but starts with null
	private static final long serialVersionUID =1L;
	public String owner;
	public int size=4;
	//constructor
	public Dog(int _size, String _name) {
		size=_size;
		name=_name;
	}

	public Dog(String _name){
		name=_name;
	}
	//method of being adopted
	public void adoptedBy(String own) {
		owner=own;
		System.out.println("Wuf, my owner is now: "+owner);
	}

}
