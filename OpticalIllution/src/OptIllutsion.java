


import java.awt.Color;


import processing.core.PApplet;
import vignesh.Shapes.Circle;
import vignesh.Shapes.Line;



public class OptIllutsion extends PApplet {
	
	
	
	public OptIllutsion() {
	}
	
	public void setup() { 
	}
	
	public void draw() {
		double radius = 350;
		Color fill = Color.BLACK;
		for(int x = 0; x < 32; x++) {
			if(x == 0) {
				fill = Color.BLACK;
			}
			else if(x == 1) {
				fill = Color.WHITE;
			}
			else if(x % 2 == 0) {
				fill = Color.BLACK;
			}
			else if(x % 2 == 1){
				fill = Color.WHITE;
			}
			Circle c = new Circle(width/2, height/2, radius, 1, Color.BLACK, fill);
			c.draw(this);
			radius -= 10;
		}
		Line l1 = new Line(width/2-255, height/2-250, width/2-255, height/2+250, 15, Color.MAGENTA);
		l1.draw(this);
		Line l2 = new Line(width/2+255, height/2-250, width/2+255, height/2+250, 15, Color.MAGENTA);
		l2.draw(this);
		Line l3 = new Line(width/2-255, height/2-250, width/2+255, height/2-250, 15, Color.MAGENTA);
		l3.draw(this);
		Line l4 = new Line(width/2-255, height/2+250, width/2+255, height/2+250, 15, Color.MAGENTA);
		l4.draw(this);
	} 	
}
