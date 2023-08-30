import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {
    
	public static void main(String[] args) {

		PuzzleJava generator = new PuzzleJava();

		ArrayList<Integer> randomRolls = generator.getTenRolls();
        char randomLetter = generator.getRandomLetter();
        String randomPassword = generator.generatePassword();
        ArrayList<String> randomPasswordList = generator.getNewPassword(4);
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        Integer[] randomizedArray = generator.shuffleArray(array);

		System.out.println(randomRolls);
		System.out.println(randomLetter);
        System.out.println(randomPassword);
        System.out.println(randomPasswordList);
        for(Integer value : randomizedArray){
            System.out.println(value);
        }
        System.out.println(randomizedArray);
	}
}
