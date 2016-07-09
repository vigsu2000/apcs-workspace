package vignesh.Shapes;
import java.awt.Color;

import processing.core.PApplet;

/**
 * @author VIGNESH
 * @version 9/27/2015
 */
public class Line extends GeometricFigure {
	private double x1, y1, x2, y2;
	private double xIntersect, yIntersect;
	/**
	 * Creates a line object
	 * @param x1 x coordinate of first point of line
	 * @param y1 y coordinate of first point of line
	 * @param x2 x coordinate of second point of line
	 * @param y2 y coordinate of second point of line
	 * @param strokeWeight is the thickness of the line
	 * @param strokeColor is the color of the line
	 */
	public Line(double x1, double y1, double x2, double y2, double strokeWeight, Color strokeColor) {
		super(strokeWeight, strokeColor);
		this.x1 = x1; 
		this.y1 = y1; 
		this.x2 = x2; 
		this.y2 = y2;
	}

	/**
	 * sets the second point of the line
	 * @param x2 x coordinate that the line's point is being set to
	 * @param y2 y coordinate that the line's point is being set to
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2; 
		this.y2 = y2;
	}

	/**
	 * draws a line
	 * @param drawer is the PApplet processing library that is used to draw the line
	 * @pre drawer cannot be null
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);
		drawer.line((float)x1, (float)y1, (float)x2, (float)y2);
	}

	/**
	 * checks to see if segments intersect each other
	 * @param other is the line that is being checked to see if it intersects with another line
	 * @return true if segments intersect, false if they don't
	 */
	public boolean intersects(Line other) {
		boolean result = false;
		double x3 = other.x1;
		double y3 = other.y1;
		double x4 = other.x2;
		double y4 = other.y2;
		double topX = (x1*y2 - y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4);
		double bottomX = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
		double topY = (x1*y2 - y1*x2)*(y3 - y4) - (y1 - y2)*(x3*y4 - y3*x4);
		double bottomY = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
		xIntersect = topX/bottomX; 
		yIntersect = topY/bottomY;
		if(Math.abs(bottomX) < 0.00000001) {
			result = false;
		}
		else if((xIntersect <= x1 && xIntersect >= x2 || xIntersect >= x1 && xIntersect <= x2) && 
				(xIntersect <= x3 && xIntersect >= x4 || xIntersect >= x3 && xIntersect <= x4) && 
				(yIntersect <= y1 && yIntersect >= y2 || yIntersect >= y1 && yIntersect <= y2) && 
				(yIntersect <= y3 && yIntersect >= y4 || yIntersect >= y3 && yIntersect <= y4)) {
			result = true;	
		}

		return result;


	}

}
