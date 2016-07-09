import java.awt.Color;

import javax.swing.JButton;

import processing.core.PApplet;
import vignesh.Shapes.Rectangle;
import vignesh.Shapes.Circle;
import vignesh.Shapes.Sphere;
import vignesh.Shapes.RegularPolygon;
import vignesh.Shapes.Line;

public class DrawingSurface extends PApplet {
	private Arrow arrow;
	
	public DrawingSurface() {
		arrow = new Arrow(500, 750, 250, 4, Color.BLUE);
	}
	
	public void setup() {
    
	}
	
	public void draw() {   	
		arrow.drawArrow(this);
	} 

}
