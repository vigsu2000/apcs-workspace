import processing.core.PApplet;

public class FractalBox {
	private int level;
	private double length;
	
	public FractalBox(int level, double length) {
    	this.level = level;
    	this.length = length;
    }
	
	public void draw(PApplet drawer) {
		drawFractalBox(drawer, level, length, drawer.width/2 -100, drawer.height/2 - 100);
	}
	
	public void drawFractalBox(PApplet drawer, int level, double length, double x, double y) {
		drawer.stroke(0);
		drawer.fill(0);
		if(level < 1) {
			drawer.rect((float)x, (float)y, (float)length, (float)length);
		}
		else {
			drawFractalBox(drawer, level-1, length/3, x+length/3, y+length/3);
			drawFractalBox(drawer, level-1, length/3, x+2*length/3, y+2*length/3);
			drawFractalBox(drawer, level-1, length/3, x+2*length/3, y);
			drawFractalBox(drawer, level-1, length/3, x, y+2*length/3);
			drawFractalBox(drawer, level-1, length/3, x, y);
		}
	}

}
