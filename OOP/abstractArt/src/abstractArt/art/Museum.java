package abstractArt.art;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		
		Painting painting1 = new Painting("Title 1", "Author 1", "This is a piece of Art", "It's Paint");
		Painting painting2 = new Painting("Title 2", "Author 2", "second art peice", "It's Paint");
		Painting painting3 = new Painting("Title 3", "Author 3", "more art", "more Paint");
		Sculpture sculpture1 = new Sculpture("Title 3", "Author 3", "more art", "rock");
		Sculpture sculpture2 = new Sculpture("Title 3", "Author 3", "more art", "different rock");
		
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting3);
		museum.add(sculpture1);
		museum.add(sculpture2);
		
		Collections.shuffle(museum);
		
		for(Art art : museum) {
			art.viewArt();
		}
	}
	

}
