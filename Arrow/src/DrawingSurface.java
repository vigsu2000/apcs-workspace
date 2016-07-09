import java.awt.Color;
import java.awt.Graphics;

public class DrawingSurface {
	private Wall w;
	
	
	public DrawingSurface() {
		w = new Wall(20, 200, 10, 60, 10, Color.BLUE);
	}
	
	public void draw(Graphics g) {   	
		w.draw(g);
		w.run();
	} 
	

}
