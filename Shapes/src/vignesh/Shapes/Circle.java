package vignesh.Shapes;
import java.awt.Color;

import processing.core.PApplet;

/**
 * @author VIGNESH
 * @version 9/27/2015
 */
public class Circle extends GeometricFigure{

	private double x, y, radius;
	public Circle() {
		super(0, Color.WHITE, Color.WHITE);
		x = 0;
		y = 0;
		radius = 0;
	}
	/**
	 * Creates a circle object
	 * @param x is the x coordinate of the circle
	 * @param y is the y coordinate of the circle
	 * @param radius is the radius of the circle
	 * @param strokeWeight is the width of the line that draws the circle
	 * @param strokeColor is the color of the line that draws the circle
	 * @param fillColor is the color that the circle is filled with
	 */
	public Circle(double x, double y, double radius, double strokeWeight, Color strokeColor, Color fillColor) {
		super(strokeWeight, strokeColor, fillColor);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public Circle(double x, double y, double radius, double strokeWeight, Color strokeColor) {
		super(strokeWeight, strokeColor);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	/**
	 * calculates the circumference of the circle based on the radius
	 * @return the circumference of the circle
	 */
	public double getCircumference() {
		return Math.PI * (radius*2);
	}

	/**
	 * calculates the area of the circle based on the radius
	 * @return the area of the circle
	 */
	public double getArea() {
		return Math.PI * (radius*radius);	
	}

	/**
	 * checks to see if the point passed in is inside the circle 
	 * @param x is the x coordinate of the point you are checking to see if it is inside the circle
	 * @param y is the y coordinate of the point you are checking to see if it is inside the circle
	 * @return boolean true if the point is inside the circle, or false if it is not
	 */
	public boolean isPointInside(double x, double y) {
		if((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y) < radius* radius) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 
	 * @param xNew the x coordinate that the circle is being moved to
	 * @param yNew the y coordinate that the circle is being moved to
	 */
	public void moveToLocation(int xNew, int yNew) {
		x = xNew;
		y = yNew;
	}
	/**
	 * Draws an circle
	 * @param drawer is the drawing tool that is used to draw the circle
	 * @pre drawer cannot be null
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);
		drawer.ellipse((float)x, (float)y, (float)radius*2, (float)radius*2);
	}

	/**
	 * moves the circle by a certain amount
	 * @param x how much the x coordinate is being moved by
	 * @param y how much the y coordinate is being moved by
	 */
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}
	/**
	 * 
	 * @return double x coordinate of the circle
	 */
	public double getX() {
		return x;
	}
	/**
	 * 
	 * @return double y coordinate of the circle
	 */
	public double getY() {
		return y;
	}
	/**
	 * 
	 * @return double radius of the circle
	 */
	public double getRadius() {
		return radius;
	}
}
