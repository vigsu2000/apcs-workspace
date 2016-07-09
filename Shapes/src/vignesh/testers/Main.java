package vignesh.testers;

import javax.swing.JFrame;


public class Main {
	
	public static void main(String args[]) {
		OptIllusion illusion = new OptIllusion();
		illusion.init();
		JFrame window = new JFrame();
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(illusion);
		window.setVisible(true);
	}
}

