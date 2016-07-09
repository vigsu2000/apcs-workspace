package vignesh.Shapes;
import java.awt.Color;

import processing.core.PApplet;

/**
 * @author VIGNESH SURESH
 * @version 9/27/2015
 */
public class Sphere extends GeometricFigure {
	private double x, y, z, radius;
	public Sphere() {
		super(0, Color.WHITE, Color.WHITE);
		x = 0;
		y = 0;
		radius = 0;
		z = 0;
	}
	
	/**
	 * Creates a sphere object
	 * @param x is the x coordinate of the sphere
	 * @param y is the y coordinate of the sphere
	 * @param z is the z coordinate of the sphere
	 * @param radius is the radius of the sphere
	 * @param strokeWeight is the thickness of the lines used to draw the sphere
	 * @param strokeColor is the color of the lines used to draw the sphere
	 * @param fillColor is the color that the sphere is filled with
	 */
	public Sphere(double x, double y, double z, double radius, double strokeWeight, Color strokeColor, Color fillColor) {
		super(strokeWeight, strokeColor, fillColor);
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
	}
	
	/**
	 * Creates an unfilled sphere object
	 * @param x is the x coordinate of the sphere
	 * @param y is the y coordinate of the sphere
	 * @param z is the z coordinate of the sphere
	 * @param radius is the radius of the sphere
	 * @param strokeWeight is the thickness of the lines used to draw the sphere
	 * @param strokeColor is the color of the lines used to draw the sphere
	 */
	public Sphere(double x, double y, double z, double radius, double strokeWeight, Color strokeColor) {
		super(strokeWeight, strokeColor);
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
	}
	
	/**
	 * calculates the volume of the sphere based on the radius
	 * @return double volume of the sphere
	 */
	public double getVolume() {
		return Math.PI * radius * radius * radius * (4/3);
	}
	
	/**
	 * calculates the surface area of the sphere based on the radius
	 * @return double surface area of the sphere
	 */
	public double getSurfArea() {
		return 4 * Math.PI * radius * radius;
	}
	
	/**
	 * Draws a circle
	 * @param drawer is the drawing tool used to draw the sphere
	 * @pre drawer cannot be null
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);
		if(z > 1) {
			drawer.ellipse((float) x, (float) y, (float) radius*2*2, (float) radius*2*2);
			drawer.ellipse((float) x, (float) y, (float) radius*2*2, (float) radius);
		}
		else if(z < 1) {
			drawer.ellipse((float) x, (float) y, (float) radius, (float) radius);
			drawer.ellipse((float) x, (float) y, (float) radius, (float) radius/4);
		}
		else if(z == 1){
			drawer.ellipse((float) x, (float) y, (float) radius*2, (float) radius * 2);
			drawer.ellipse((float) x, (float) y, (float) radius*2, (float) radius/2);
		}
	}
	
	/**
	 * moves the x and y coordinates of the sphere to the coordinates passed in
	 * @param xNew the new x location that the x coordinate of the sphere is being moved
	 * @param yNew the new y location that the y coordinate of the sphere is being moved
	 */
	public void moveToLocation(int xNew, int yNew) {
		x = xNew;
		y = yNew;
	}
	
	/**
	 * moves the sphere by a certain amount
	 * @param x is how much the x coordinate of the sphere is being moved by
	 * @param y is how much the y coordinate of the sphere is being moved by
	 */
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * changes the radius of the sphere to make the sphere bigger or smaller
	 * @param scale is how much the radius of the sphere is being changed by
	 */
	public void changeSize(int scale) {
		if(radius > Math.abs(scale) && scale <= 0) {
			radius += scale;
		}
		else if(scale > 0){
			radius += scale;
		}
		else {
			radius += 0;
		}
	}
		
}
