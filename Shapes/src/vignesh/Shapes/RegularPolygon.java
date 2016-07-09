package vignesh.Shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author VIGNESH SURESH
 * @version 9/29/15
 *
 */
public class RegularPolygon extends GeometricFigure {
	private double x, y;
	private int numSides; 
	private double sideLength;   
    private Line c;      

	
	/**
	 * 
	 * @param x is the x coordinate of the triangle
	 * @param y is the y coordinate of the triangle
	 * @param sideLength is the length of each side of the triangle
	 * @param strokeWeight is the thickness of the lines that draw the triangle
	 * @param strokeColor is the color of the lines that draw the triangle
	 * @param fillColor is the color that fills the triangle
	 */
	public RegularPolygon(double x, double y, int numOfSides, double sideLength, double strokeWeight, Color strokeColor, Color fillColor) {
		super(strokeWeight, strokeColor, fillColor);
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
		this.numSides = numOfSides;
	}
	
	/**
	 * 
	 * @param x is the x coordinate of the regular polygon
	 * @param y is the y coordinate of the regular polygon
	 * @param sideLength is the length of each side of the regular polygon
	 * @param strokeWeight is the thickness of the lines that draw the regular polygon
	 * @param strokeColor is the color of the lines that draw the regular polygon
	 */
	public RegularPolygon(double x, double y, double numOfSides, double sideLength, double strokeWeight, Color strokeColor) {
		super(strokeWeight, strokeColor);
		this.x = x;
		this.y = y;
		this.sideLength = sideLength;
	}
	

	   
	   //private methods
	   private double calcr() {
		   double r = (sideLength/2) * 1/Math.tan(Math.PI/numSides);
		   return r;
	   }
	
	   private double calcR(){
		   double R = (sideLength/2) * 1/Math.sin(Math.PI/numSides);
		   return R;
	   }   
	   
	   // public methods
	   public double calcVertexAngle(){
		   return ((numSides-2)/numSides) * 180;
	   }

	   public double calcPerimeter(){
		   return numSides*sideLength;
	   }
	   
	   public double calcArea(){
		   double area =(1/2)*numSides*(calcR()*calcR())*Math.sin((2*Math.PI)/Math.PI);
		   return area;
	   }

	   public int getNumSides(){
		   return numSides;
	   }

	   public double getSideLength(){
		   return sideLength;
	   }
	   
	   public double getR(){
		   return calcR();
	   }
	   
	   public double getr(){
		   return calcr();
	   }
	   
	   /**
	    * Draws the regular polygon
	    * @param marker is the drawing tool used to draw the regular polygon
	    * @pre marker cannot be null
	    * @post fillColor will be changed
	    */
	   public void draw(PApplet marker){
		   super.draw(marker);
		   double centralAngle = 2 * Math.PI / numSides;
		   int a = 0;
		   while(a < numSides) {
			   float x1 = (float) (x + calcR() * Math.cos(a * centralAngle));
			   float y1 = (float) (y + calcR() * Math.sin(a * centralAngle));
			   float x2 = (float) (x + calcR() * Math.cos((a + 1) * centralAngle));
			   float y2 = (float) (y + calcR() * Math.sin((a + 1) * centralAngle));
			   Line c = new Line(x1, y1, x2, y2, 1, super.getStrokeColor());
			   c.draw(marker);
			   a++;
		   }
	   }

	   public void drawBoundingCircles(PApplet marker){
		   marker.noFill();
		   Circle inCircle = new Circle(x, y, calcr(), 1, Color.BLACK);
		   Circle outCircle = new Circle(x, y, calcR(), 1, Color.BLACK);
		   outCircle.draw(marker);
		   inCircle.draw(marker);
	   }

	}
