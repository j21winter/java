package zooKeeper.animals;

public class Mammal {
	protected int energyLevel  = 100; 
	
	protected int displayEnergy() {
		System.out.printf("Energy Level: %s\n\n", energyLevel);
		return energyLevel;
	}
	
	
}
