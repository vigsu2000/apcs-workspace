package vignesh.Shapes;
import java.awt.Color;
import java.awt.event.KeyEvent;

import processing.core.PApplet;

/* 1. The method isPointInside also checks for negative x-values, not just positive.
 * 2. The methods relate to each other and do what the class is supposed to model.
 * 
 */

/**
 * @author VIGNESH SURESH
 * @version 9/27/2015
 */
public class Rectangle extends GeometricFigure {

	private double x, y, width, height;
	public Rectangle() {
		super(0, Color.WHITE, Color.WHITE);
		x = 0;
		y = 0;
		width = 0;
		height = 0;
	}
	/**
	 * Creates a rectangle object
	 * @param x is the x coordinate of the upper left corner of the rectangle
	 * @param y is the y coordinate of the upper left corner of the rectangle
	 * @param width is the width of the rectangle
	 * @param height is the height of the rectangle
	 * @param strokeWeight is the thickness of the lines used to draw the rectangle
	 * @param strokeColor is the color of the lines used to draw the rectangle
	 * @param fillColor is the color that fills the rectangle
	 */
	public Rectangle(double x, double y, double width, double height, double strokeWeight, Color strokeColor, Color fillColor) {
		super(strokeWeight, strokeColor, fillColor);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a rectangle object
	 * @param x is the x coordinate of the upper left corner of the rectangle
	 * @param y is the y coordinate of the upper left corner of the rectangle
	 * @param width is the width of the rectangle
	 * @param height is the height of the rectangle
	 * @param strokeWeight is the thickness of the lines used to draw the rectangle
	 * @param strokeColor is the color of the lines used to draw the rectangle
	 */
	public Rectangle(double x, double y, double width, double height, double strokeWeight, Color strokeColor) {
		super(strokeWeight, strokeColor);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * calculates the perimeter of the rectangle based on the width and height
	 * @return double value of perimeter of rectangle
	 */
	public double getPerimeter() {
		return Math.abs(width*2) + Math.abs(height*2);		
	}
	/**
	 * calculates the area of the rectangle based on the width and height
	 * @return double value of area of rectangle
	 */
	public double getArea() {
		return Math.abs(width) * Math.abs(height);		
	}

	/**
	 * checks to see if the point passed in is inside the rectangle
	 * @param x is the x coordinate of the point you are checking to see if it is inside the rectangle
	 * @param y is the y coordinate of the point you are checking to see if it is inside the rectangle
	 * @return boolean true if the point is inside the rectangle, or false if it is not
	 */
	public boolean isPointInside(double x, double y) {
		if(((x > this.x && x < this.x+width) || (x < this.x && x > this.x+width)) && 
				((y > this.y && y < this.y+height) || (y < this.y && y> this.y+height))) {
			return true;
		}
		else {
			return false;
		}		
	}
	/**
	 * Draws a rectangle
	 * @param marker is the PApplet processing library that is used to draw the rectangle
	 * @pre marker cannot be null
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float)x, (float)y, (float)width, (float)height);
	}

	/**
	 * moves the rectangle to a new location
	 * @param xNew the x coordinate that the rectangle is being moved to
	 * @param yNew the y coordinate that the rectangle is being moved to
	 */
	public void moveToLocation(int xNew, int yNew) {
		x = xNew - width/2;
		y = yNew - height/2;
	}

	/**
	 * moves the rectangle by a certain amount
	 * @param x how much the x coordinate is being moved by
	 * @param y how much the y coordinate is being moved by
	 */
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y; 
	}

	/**
	 * 
	 * @return double width of the rectangle
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * 
	 * @return double height of the rectangle
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * 
	 * @return double x coordinate of the rectangle
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 * @return double y coordinate of the rectangle
	 */
	public double getY() {
		return y;
	}
}



