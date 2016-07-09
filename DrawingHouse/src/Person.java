import processing.core.PApplet;
/*
 * +
 * nice method names - very descriptive.
 * nice syntax.
 * CHANGES
 * 
 * 
 */


public class Person {
	private int xCoord, yCoord;
	private int headWidth, headHeight;
	
	public Person() {
		headWidth = 40;
		headHeight = 40;
		xCoord = 50;
		yCoord = 190;
	}
	
	public void drawPerson(PApplet drawer) {
		drawer.rect(xCoord, yCoord, headWidth, headHeight);
		drawer.line(xCoord + headWidth/2, yCoord+headHeight, xCoord+headWidth/2, yCoord+headHeight+headHeight*3/2);
		drawer.line(xCoord+headWidth/2, yCoord+headHeight+headHeight*3/2, xCoord, yCoord+headHeight*2+headHeight*3/2);
		drawer.line(xCoord+headWidth/2, yCoord+headHeight+headHeight*3/2, xCoord+headWidth, yCoord+headHeight*2+headHeight*3/2);
		drawer.line(xCoord+headWidth/2, yCoord+headHeight+(headHeight*3/2)/2, xCoord, yCoord+headHeight+headHeight*3/2);
		drawer.line(xCoord+headWidth/2, yCoord+headHeight+(headHeight*3/2)/2, xCoord+headWidth, yCoord+headHeight+headHeight*3/2);
	}
	
	public void increaseSize() {
		headWidth += 4;
		headHeight += 4;
		xCoord -= 2;
		yCoord -= 2;
	}

	public void decreaseSize() {
		if(headWidth > 4) {
		headWidth -= 4;
		headHeight -= 4;
		xCoord += 2;
		yCoord += 2;
		}
	}
}
