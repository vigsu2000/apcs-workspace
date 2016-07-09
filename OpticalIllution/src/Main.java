



import javax.swing.JFrame;




public class Main {
	
	public static void main(String args[]) {
		OptIllutsion drawing = new OptIllutsion();
		drawing.init();
		JFrame window = new JFrame();
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(drawing);
		window.setVisible(true);
		window.addKeyListener(drawing);
		window.addMouseListener(drawing);
	}
}

