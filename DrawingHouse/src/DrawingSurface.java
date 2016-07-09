import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import processing.core.PApplet;

//commenting
//add fields
//split methods

public class DrawingSurface extends PApplet {
	private House house;
	private Person person;
	
	
	public DrawingSurface() {
		house = new House();
		person = new Person();
	}
	
	public void setup() {
  
		stroke(0);     
	}
	
	public void draw() {   	
		background(255);
		house.drawHouse(this);
		person.drawPerson(this);
		
	} 
	
	public void mousePressed() {
		house.move(mouseX, mouseY);
	}
	
	public void keyPressed() {
		if (keyCode == UP) {
			//house.changeScale(20);
			house.increaseSize();
			person.increaseSize();
			
	    } else if (keyCode == DOWN) {
		    //house.changeScale(-20);
		    house.decreaseSize();
		    person.decreaseSize();
	    } 
	} 
}

	/*public void mousePressed(MouseEvent e) {
		int mouseLocX = e.getX();
		int mouseLocY = e.getY();
		xCoord = mouseLocX - 150;
		yCoord = mouseLocY - 75;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			ratioX -= 20f;
			ratioY -= 20f;
			xCoord -= 10;
			yCoord -= 10;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			ratioX += 20f;
			ratioY += 20f;
			xCoord += 10;
			yCoord += 10;
		}*/
	
