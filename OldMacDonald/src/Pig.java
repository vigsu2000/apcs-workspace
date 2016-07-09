
public class Pig implements Animal {
	
	private String myType;
	private String mySound;
	
	public Pig() {
		myType = "pig";
	    mySound = "oink";
	}
	
	public String getSound() {
		return mySound;
	}

	public String getType() {
		return myType;
	}
	
	public String toString() {
		return "The " + getType() + " goes " + getSound();
	}

}
