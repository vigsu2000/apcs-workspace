import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList
import processing.core.PApplet;	// for Processing

public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon;
    
   // constructors
   public IrregularPolygon() {
	   myPolygon = new ArrayList <Point2D.Double> ();
   }
   
   // public methods
   public void add(Point2D.Double aPoint) {
	   myPolygon.add(aPoint);
   }

   public void draw(PApplet marker) {
	   if(myPolygon.size() > 2) {
	   for(int a = 0; a < myPolygon.size()-1; a++) {
		   marker.line((float)myPolygon.get(a).x, (float)myPolygon.get(a).y, (float)myPolygon.get(a+1).x, (float)myPolygon.get(a+1).y);
	   }
	   marker.line((float)myPolygon.get(myPolygon.size()-1).x, (float)myPolygon.get(myPolygon.size()-1).y, (float)myPolygon.get(0).x, (float)myPolygon.get(0).y);
	   }
	   else if(myPolygon.size() == 2) {
		   marker.line((float)myPolygon.get(myPolygon.size()-1).x, (float)myPolygon.get(myPolygon.size()-1).y, (float)myPolygon.get(0).x, (float)myPolygon.get(0).y);
	   }
   }

   public double perimeter() {
	   double total=0;
		if(myPolygon.size()>=2)
		{
			for(int i =1;i<myPolygon.size();i++)
			{
				Point2D.Double one=myPolygon.get(i);
				Point2D.Double two=myPolygon.get(i-1);
				double x=Math.abs((one.getX()-two.getX()));
				double y=Math.abs((one.getY()-two.getY()));
				total+=Math.sqrt((x*x)+(y*y));
			}
			return total;   
		}
		return 0;
   }

   public double area() {
	   double area=0;
		for(int i =0;i<myPolygon.size();i++)
		{
			if(i==myPolygon.size()-1)
			{
				area+=(myPolygon.get(i).getX())*(myPolygon.get(0).getY());
				break;
			}
			area+=(myPolygon.get(i).getX())*(myPolygon.get(i+1).getY());
		}
		for(int i =0;i<myPolygon.size();i++)
		{
			if(i==myPolygon.size()-1)
			{
				area-=(myPolygon.get(i).getY())*(myPolygon.get(0).getX());
				break;
			}
			area-=(myPolygon.get(i).getY())*(myPolygon.get(i+1).getX());
		}
		return area/2;
   }
}