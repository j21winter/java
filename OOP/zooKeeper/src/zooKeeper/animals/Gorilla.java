package zooKeeper.animals;

public class Gorilla extends Mammal{
	
	public void throwSomething() {
		if(energyLevel > 5) {
			energyLevel -= 5;
			System.out.println("Throwing Something");
			displayEnergy();
		}
		else {
			System.out.println("Too tired to throw stuff");
		}
	}
	
	public void eatBanana() {
		energyLevel += 10;
		System.out.println("Nom Nom Bananas!");
		displayEnergy();
	}
	
	public void climb() {
		if(energyLevel > 10) {
			energyLevel -= 10;
			System.out.println("Nice view from this tree");
			displayEnergy();
		}
		else {
			System.out.println("Too tired to climb");
		}
	}

}
