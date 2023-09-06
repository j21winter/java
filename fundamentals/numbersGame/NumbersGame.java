import java.util.Random;
public class NumbersGame {
    public static void main(String[] args){

        boolean playing = true;

        while(playing){

            System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
            System.out.println("*********************************************************");
            System.out.println("Can you guess the number?");
            System.out.println("If you are not up to the task, you can always type 'q' to quit.");

            int answer = new Random().nextInt(11);
            // System.out.println(answer);

            int count = 3;
            while(count > 0){
                System.out.println("Guesses remaining: " + count);
                String guess = System.console().readLine().trim();

                if(guess.equals("q")){
                    System.out.println("I knew you didn't have it in you.");
                    System.out.println("Shutting down...");
                    break;
                }

                else if(!onlyNumbers(guess) || guess.length() < 1){
                    System.out.println("Invalid input\nTry again with numbers only:");
                }

                else if(Integer.parseInt(guess)<0 || Integer.parseInt(guess)>10 ){
                    System.out.println("Guess must be between 0-10.\nTry again:");
                }

                else if(Integer.parseInt(guess)==answer){
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                }

                else{
                    System.out.println("Swing and a miss! Keep trying...");
                    count -= 1;
                    if(Integer.parseInt(guess) > answer ){
                        System.out.print("\nToo High!\n");
                    }
                    else if(Integer.parseInt(guess) < answer ){
                        System.out.print("\nToo low!\n");
                    }
                }

            if(count == 0){
                System.out.println("You have run out of guesses... ");
                System.out.printf("\nAnswer was %s\n", answer);
            }
            }

            System.out.println("Play again? yes/no");
            String response = System.console().readLine().trim();

            if(response.toLowerCase().equals("yes")){
                playing = true;
            } else {
                System.out.println("Game over. Shutting down...");
                playing = false;
            }
        }
    }
    

    public static boolean onlyNumbers(String input){
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for(int i = 0; i < input.length(); i++){
            char character = input.charAt(i);
            if (character < '0' || character > '9'){
                return false;
            }
        }
        return true;
    }
}
