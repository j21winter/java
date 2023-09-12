package abstractArt.art;

public class Painting extends Art {

	private String paintType; 
	
	public Painting(String title, String author, String description, String paintType) {
		super.title = title;
		super.author = author;
		super.description = description;
		this.paintType = paintType;
	}
	
	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		System.out.printf("Title: %s\nAuthor: %s\nDescription: %s\nPaint Type: %s\n\n", title, author, description, paintType);

	}

}
