
public class Character {

	private String name;
	private String discription;
	private int lives;
	public Character(String n, String d, int l) {
		this.name = n;
		this.discription = d;
		this.lives = l;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}


}
