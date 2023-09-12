package main;
import zooKeeper.animals.Gorilla;
import zooKeeper.animals.Bat;

public class zooTest {

	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla();
		Bat bat = new Bat();
		
		System.out.println("******* Gorilla Testing *********");
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.throwSomething();
		
		gorilla.eatBanana();
		gorilla.eatBanana();
		
		gorilla.climb();
		
		System.out.println("******* Bat Testing *********");
		bat.attackTown();
		bat.eatHumans();
		bat.attackTown();
		bat.eatHumans();
		bat.attackTown();
		bat.fly();
		bat.fly();		
		
	}

}
