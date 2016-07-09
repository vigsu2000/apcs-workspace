import processing.core.PApplet;

public class Line {
	private double x1, y1, x2, y2;
	private double xIntersect, yIntersect;

	// Constructs a line from (x1, y1) to (x2, y2)
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1; 
		this.y1 = y1; 
		this.x2 = x2; 
		this.y2 = y2;
	}

	// Sets this line’s second point (x2, y2) to a new coordinate
	public void setPoint2(double x2, double y2) {
		this.x2 = x2; 
		this.y2 = y2;
	}

	// Draws this line using the PApplet passed as an argument
	public void draw(PApplet drawer) {
		drawer.line((float)x1, (float)y1, (float)x2, (float)y2);
		drawer.ellipse((float)xIntersect, (float)yIntersect, 5f, 5f);
	}

	// Returns true if this line segment and the segment other intersect each other. Returns false if they do not intersect.
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
