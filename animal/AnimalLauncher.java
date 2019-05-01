package animal;
import java.util.ArrayList;
//main class
public class AnimalLauncher {
	public static void main(String args[]) {
	Dog doggy = new Dog(3, "Dingo");
	doggy.cry();
	doggy.adoptedBy("Dan");
	Animal doggy2 = new Dog("Duddly");
	Dog dog = (Dog)doggy2;
	System.out.println(dog.size);

	Animal doggy3 = new Dog(5,"Dug");
	System.out.println(doggy3.size);
	Cat kitty = new Cat(5, "Cassy");
	kitty.cry();
	
	//checking vetpet
	Vet vet = new Vet();
	vet.askName(doggy);
	PetOwner own= new PetOwner();
	own.answerName(doggy);
	System.out.println("s");
	}
}

