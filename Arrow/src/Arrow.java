import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arrow extends JPanel {
	
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		JFrame window = new JFrame();
		window.setSize(600, 800);
		window.getContentPane().add(drawing);
		window.setVisible(true);
	}
}