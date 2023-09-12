package abstractArt.art;

public class Sculpture extends Art {

	private String material;
	
	public Sculpture (String title, String author, String description, String material) {
		super.title = title;
		super.author = author;
		super.description = description;
		this.material = material;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public void viewArt() {
		System.out.printf("Title: %s\nAuthor: %s\nDescription: %s\nPaint Type: %s\n\n", title, author, description, material);
	}

}
