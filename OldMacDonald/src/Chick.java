
public class Chick implements Animal {

	private String myType;
	private String mySound;
	
	public Chick() {
		myType = "chick";
	    int randNum = (int)(Math.random()*2);
	    if(randNum == 0) {
	    	mySound = "cluck";
	    }
	    else {
	    	mySound = "cheep";
	    }
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
