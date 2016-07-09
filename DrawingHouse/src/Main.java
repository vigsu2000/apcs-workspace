import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		drawing.init();
		JFrame window = new JFrame();
		window.setSize(500, 500);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(drawing);
		window.setVisible(true);
		window.addKeyListener(drawing);
		window.addMouseListener((MouseListener) drawing);
	}
}
