
import java.awt.Color;

import javax.swing.JButton;

import processing.core.PApplet;


public class DrawingSurface extends PApplet {
	private Person p;
	private Teacher t;
	private Student s;
	private CollegeStudent cs;
	
	public DrawingSurface() {
		p = new Person("Bob Smith", 40, "M");
		t = new Teacher("Walter White", 52, "M", "Chemistry", 40000);
		s = new Student("Vignesh Suresh", 16, "M", "5141611", 1000000);
		cs = new CollegeStudent("Rohan Suresh", 19, "M", "9862625620", 1, 1, "Electrical Engineering/Computer Science");
	}
	
	public void setup() {
		this.background(255);
	}
	
	public void draw() {
		p.draw(this, 50, 50, 200, 200);
		t.draw(this, 150, 150, 200, 200);
		s.draw(this, 250, 250, 200, 200);
		cs.draw(this, 350, 350, 200, 200);
	} 

}
