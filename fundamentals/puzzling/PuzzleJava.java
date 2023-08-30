import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava{

    Random random = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <=10; i ++){
            result.add(random.nextInt(1,21));
        }
        return result;
    }

    public char getRandomLetter(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char result = alphabet[random.nextInt(26)];
        return result;
    }

    public String generatePassword(){
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < 8; i++){
            char letter = getRandomLetter();
            password.append(letter);
        }
        
        return password.toString();
    }

    public ArrayList<String> getNewPassword(int amount){
        ArrayList<String> results = new ArrayList<String>();
        for(int i = 0; i < amount; i++){
            // String password = generatePassword();
            results.add(generatePassword());
        }
        return results;
    }

    public <T> T[] shuffleArray(T[] array){
        int random1 = random.nextInt(10);
        for(int i = 0; i <= random1; i++){
            int random2 = random.nextInt(array.length);
            int random3 = random.nextInt(array.length);
            T temp = array[random2];
            array[random2] = array[random3];
            array[random3] = temp;
            }
        return array;
    }
}