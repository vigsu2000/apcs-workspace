import processing.core.PApplet;

public class House {

	private int width, height;
	private int xCoord, yCoord;
	private int windowWidth;
	private int windowX1, windowX2, windowY1, windowY2;
	private int doorWidth, doorHeight;
	private int doorX, doorY;
	private int lineY2;
	private float ratioX;
	private float ratioY;
		
	public House() {
		xCoord = 100;
		yCoord = 180;
		width = 300;
		height = 150;
		windowWidth = 60;
		windowX1 = 120;
		windowX2 = 320;
		windowY1 = 200;
		windowY2 = 200;
		doorWidth = 40;
		doorHeight = 60;
		doorX = 230;
		doorY = 270;
		lineY2 = 130;
		ratioX = 501f;
		ratioY = 460f;
	}
		
	public void drawHouse(PApplet drawer) { //x = 80  y = 150
		/*float xRatio = drawer.width/ratioX;
		float yRatio = drawer.height/ratioY;
		drawer.scale(xRatio, yRatio);*/
		
		drawer.noFill();
		drawer.rect(xCoord, yCoord, width, height);
		drawer.rect(doorX, doorY, doorWidth, doorHeight);
		drawer.rect(windowX1, windowY1, windowWidth, windowWidth);
		drawer.rect(windowX2, windowY2, windowWidth, windowWidth);
		drawer.triangle(xCoord, yCoord, xCoord+width, yCoord, width/2+xCoord, lineY2);
	}
	
	public void move(int xNew, int yNew) {
		int w1 = windowX1 - xCoord;
		int w2 = windowY1 - yCoord;
		int w3 = windowX2 - xCoord;
		int w4 = windowY2 - yCoord;
		int l = yCoord - lineY2;
		xCoord = xNew - width/2;
		yCoord = yNew - (height-l/2)/2;
		lineY2 = yCoord - l;
		windowX1 = xCoord + w1;
		windowY1 = yCoord + w2; 
		windowX2 = xCoord + w3;
		windowY2 = yCoord + w4;
		doorX = (xCoord+width-doorWidth/2) - width/2;
		doorY = yCoord+height-doorHeight;
	}
	
	public void increaseSize() {
		width += 30;
		height += 15;
		windowWidth += 6;
		xCoord -= 12;
		yCoord -= 10;
		windowX1 -= 10;
		windowX2 += 10;
		windowY1 -= 8;
		windowY2 -= 8;
		doorWidth += 4;
		doorHeight += 6;
		doorX += 1;
		doorY -= 1;
		lineY2 -= 15;
	}
	public void decreaseSize() {
		if(height >= 20) {
		width -= 30;
		height -= 15;
		windowWidth -= 6;
		xCoord += 12;
		yCoord += 10;
		windowX1 += 10;
		windowX2 -= 10;
		windowY1 += 8;
		windowY2 += 8;
		doorWidth -= 4;
		doorHeight -= 6;
		doorX -= 1;
		doorY += 1;
		lineY2 += 15;
		}
		else {
		width -= 0;
		height -= 0;
		windowWidth -= 0;
		xCoord += 0;
		yCoord += 0;
		windowX1 += 0;
		windowX2 -= 0;
		windowY1 += 0;
		windowY2 += 0;
		doorWidth -= 0;
		doorHeight -= 0;
		doorX += 0;
		doorY -= 0;
		lineY2 += 0;
		}
	}
	
	/*public void changeScale(double amount) {
		if(ratioX <= 1000 && ratioY <= 1000) {
		ratioX -= amount;
		ratioY -= amount;
			if(amount >= 0) {
			xCoord -= 10;
			yCoord -= 10;
			}
			else if(amount < 0){
			xCoord += 10;
			yCoord += 10;
		
		}
		}
	}*/
}
