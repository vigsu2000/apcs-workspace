
package vignesh.Shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * @author VIGNESH SURESH
 * @version 9/27/15
 */
abstract class GeometricFigure {
	private double strokeWeight;
	private Color fillColor, strokeColor;
	private boolean isFilled;

    
	 /**
     * Creates a Geometric Figure
     * @param newX is the x coordinate of the Geometric Figure
     * @param newY is the y coordinate of the Geometric Figure
     * @param newStrokeWeight is the thickness of the lines that draw the Geometric Figure
     * @param newStrokeColor is the color of the lines that draw the Geometric Figure
     * @param newFillColor is the fill color of the Geometric Figure
     */
    GeometricFigure(double newStrokeWeight, Color newStrokeColor, Color newFillColor) {
    	strokeWeight = newStrokeWeight;
    	strokeColor = newStrokeColor;
    	fillColor = newFillColor;
    	isFilled = true;
    }
	
	/**
     * Creates an unfilled Geometric Figure
     * @param newX is the x coordinate of the Geometric Figure
     * @param newY is the y coordinate of the Geometric Figure
     * @param newStrokeWeight is the thickness of the lines that draw the Geometric Figure
     * @param newStrokeColor is the color of the lines that draw the Geometric Figure
     * @param isFilled is whether or not the figure is filled
     * @pre no parameters can be null;
     */
    GeometricFigure(double newStrokeWeight, Color newStrokeColor) {
    	strokeWeight = newStrokeWeight;
    	strokeColor = newStrokeColor;
    	isFilled = false;
    }
    
    public Color getStrokeColor() {
    	return strokeColor;
    }
    public Color getFillColor() {
    	return fillColor;
    }
    public double getStrokeWeight() {
    	return strokeWeight;
    }
    

    /**
     * Moves the Geometric Figure to a new location
     * @param xNew is the x coordinate that the x coordinate of the Geometric Figure is being moved to
     * @param yNew is the y coordinate that the y coordinate of the Geometric Figure is being moved to
     */

    /**
     * Draws the Geometric Figure
     * @param drawer is the drawing tool used to draw the Geometric Figure
     * @pre drawer cannot be null
     */
    public void draw(PApplet drawer) {
    	drawer.strokeWeight((float) strokeWeight);
    	drawer.stroke(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue());
    	if(isFilled == true) {
    		drawer.fill(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue());
    	}
	}
}
