

import javax.swing.JFrame;


public class Main {
	
	public static void main(String args[]) {
		DrawingSurface i = new DrawingSurface();
		i.init();
		JFrame window = new JFrame();
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(i);
		window.setVisible(true);
	}
}

