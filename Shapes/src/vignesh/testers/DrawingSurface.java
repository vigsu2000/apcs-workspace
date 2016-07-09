package vignesh.testers;
import java.awt.Color;

import javax.swing.JButton;

import processing.core.PApplet;
import vignesh.Shapes.Rectangle;
import vignesh.Shapes.Circle;
import vignesh.Shapes.Sphere;
import vignesh.Shapes.RegularPolygon;
import vignesh.Shapes.Line;

public class DrawingSurface extends PApplet {
	private Sphere sph;
	private Circle circ;
	private Rectangle rect;
	private Line line;
	private RegularPolygon pol;
	
	public DrawingSurface() {
		sph = new Sphere(100, 100, 1, 40, 2, Color.BLACK, Color.BLUE);
		circ = new Circle(300, 300, 40, 8, Color.GREEN, Color. MAGENTA);
		rect = new Rectangle(100, 100, 50, 50, 2, Color.BLACK, Color.BLUE);
		line = new Line(100, 350, 90, 200, 16, Color.CYAN);
		pol = new RegularPolygon(400, 400, 4, 100, 1, Color.WHITE, Color.WHITE);
	}
	
	public void setup() {
    
	}
	
	public void draw() {   	
		sph.draw(this);
		rect.draw(this);
		line.draw(this);
		pol.draw(this);
		pol.drawBoundingCircles(this);
		circ.draw(this);
	} 

}
