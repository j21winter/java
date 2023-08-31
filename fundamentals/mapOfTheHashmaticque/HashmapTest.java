import java.util.HashMap;
import java.util.Set;

public class HashmapTest {
    public static void main(String[] args){
        HashMap <String, String> trackList = new HashMap <String, String>();
        trackList.put("song-1", "This is song one");
        trackList.put("song-2", "Words to song 2");
        trackList.put("song-3", "Making up random lyrics for song 3");
        trackList.put("song-4", "Final words I am filling in");

        System.out.println(trackList.get("song-1"));

        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.printf("%s : %s \n\n", key, trackList.get(key));
        }
    }

}