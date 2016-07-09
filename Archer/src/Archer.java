import javax.swing.JFrame;

public class Archer {
	
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		drawing.init();
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(drawing);
		window.setVisible(true);
	}
}