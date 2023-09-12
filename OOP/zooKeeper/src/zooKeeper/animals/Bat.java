package zooKeeper.animals;

public class Bat extends Mammal {
	public Bat() {
		super.energyLevel = 300;
	}

	
	public void fly() {
		if(energyLevel > 50) {
			this.energyLevel -= 50;
			System.out.println("Soring through the sky!");
			displayEnergy();
		}
		else {
			System.out.println("Too tired to flap!");
		}
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("Nom Nom hoomans");
		displayEnergy();
	}
	
	public void attackTown() {
		if(energyLevel > 100) {
			this.energyLevel -= 100;
			System.out.println("Destroooyyyyy!!!!!");
			displayEnergy();
		}
		else {
			System.out.println("Food sounds better right now!!");
		}
	}
	
}
