package animal;
import java.util.ArrayList;
//main class
public class AnimalLauncher {
	public static void main(String args[]) {
	Dog doggy = new Dog(3, "Dingo");
	doggy.cry();
	doggy.adoptedBy("Dan");
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

