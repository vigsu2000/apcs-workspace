import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve {

	int level;
	double length;

    public KochCurve(int level, double length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(new MemoryDrawer(marker, 200, 200, 0), level, length, 0, 200, 200);
    }

    private void drawKochCurve(MemoryDrawer drawer, int level, double length, double angle, double x, double y) {
    	if(level < 1) {
    		drawer.drawForward(length);
    	}
    	else {
    		drawKochCurve(drawer, level - 1, (length)/3, drawer.getAngle(), drawer.getX(), drawer.getY());
    		drawer.turn(60);
    		drawKochCurve(drawer, level - 1, (length)/3, drawer.getAngle(), drawer.getX(), drawer.getY());
    		drawer.turn(-120);
    		drawKochCurve(drawer, level - 1, (length)/3, drawer.getAngle(), drawer.getX(), drawer.getY());
    		drawer.turn(60);   
    		drawKochCurve(drawer, level - 1, (length)/3, drawer.getAngle(), drawer.getX(), drawer.getY());
    		}

    		
    		//Draw a k-1 level Koch curve with segments 1/3 the current length
      	  	//Turn left 60 degrees
      	  	//Draw a k-1 level Koch curve with segments 1/3 the current length
      	  	//Turn right 120 degrees
      	  	//Draw a k-1 level Koch curve with segments 1/3 the current length
      	  	//Turn left 60 degrees
      	  	//Draw a k-1 level Koch curve with segments 1/3 the current length
    	}
    }
