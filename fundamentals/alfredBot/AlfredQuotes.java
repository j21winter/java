import java.util.Date;
import java.text.SimpleDateFormat;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting() {

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(sdf.format(currentDate));

        String dayPeriod;
        if (hour >= 0 && hour <6 ){
            dayPeriod = "Night";
        }
        else if (hour >= 6 && hour <12 ){
            dayPeriod = "Morning";
        }
        else if (hour >= 12 && hour <18 ){
            dayPeriod = "Afternoon";
        }
        else{
            dayPeriod = "Evening";
        }


        String greeting = String.format("Good %s. Lovely to see you!", dayPeriod);
        return greeting;
    }

    public String guestGreeting(String name) {
        String greeting = String.format("Hello %s. Lovely to see you!", name);
        return greeting;
    }

    public String guestGreeting(String name, String dayPeriod){
        String greeting = String.format("Good %s %s. Lovely to see you!", dayPeriod.toLowerCase(), name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        String announcement = String.format("It is currently %s", date);
        
        return announcement;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis") != -1){
            String response = "Right away, sir. She certainly isn't sophisticated enough for that";
            return response;
        }
        else if (conversation.indexOf("Alfred") != -1) {
            String response = "At your service. As you wish, naturally.";
            return response;
        }
        else{
            String response = "Right. And with that I shall retire.";
            return response;
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

