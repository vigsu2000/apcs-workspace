
import java.awt.Color;

import javax.swing.JButton;

import processing.core.PApplet;
import vignesh.Shapes.Rectangle;
import vignesh.Shapes.Circle;
import vignesh.Shapes.Sphere;
import vignesh.Shapes.RegularPolygon;
import vignesh.Shapes.Line;

public class DrawingSurface extends PApplet {
	private Teacher t;
	
	public DrawingSurface() {
		t = new Teacher("Walter", 52, "Male", "Chemistry", 40000, 100, 100, 50, 50);
	}
	
	public void setup() {
    
	}
	
	public void draw() {   	
		t.draw(this);
	} 

}
