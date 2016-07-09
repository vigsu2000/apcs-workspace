import java.awt.*;


public class Wall {
	private int x, y, width, height, vel;
	private Color wallColor;
	
	public Wall(int x, int y, int width, int height, int vel, Color wallColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.vel = vel;
		y += vel;
		this.wallColor = wallColor;
	}
	
	public void run() {
		if(y >= height || y <= 600 - height) {
			vel = vel * -1;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(wallColor);
		g.fillRect(x, y, width, height);
	}

}
