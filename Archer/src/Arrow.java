import java.awt.Color;

import processing.core.PApplet;
import vignesh.Shapes.Line;

public class Arrow extends Line {
	double x1, x2;
	double y;
	double strokeWeight;
	Color strokeColor;
	boolean hitsWall;

	public Arrow(double x1, double x2, double y, double strokeWeight, Color strokeColor) {
		super(x1, y, x2, y, strokeWeight, strokeColor);
		this.x1 = x1;
		this.x2 = x2;
		this.y = y;
		this.strokeWeight = strokeWeight;
		this.strokeColor = strokeColor;
		hitsWall = false;
	}
	
	public void drawArrow(PApplet drawer) {
		drawer.background(255);
		super.draw(drawer);
		drawer.line((float)x1, (float)y, (float)((x2-x1)/4 + x1), (float)(y + (x2-x1)/4));
		drawer.line((float)x1, (float)y, (float)((x2-x1)/4 + x1), (float)(y - (x2-x1)/4));
	}

}
