/*
 * This class simulates a hardware 7-segment display, including logic to
 * display integer values stored as binary.
 *
 */

import java.awt.*;
import java.awt.geom.*;
import java.io.Serializable;
import java.awt.event.*;
import javax.swing.*;


public class SevenSegment extends JPanel implements ActionListener, Serializable, WindowListener
{
	private static final long serialVersionUID = 1L;
	private boolean[] segments;
	private RoundRectangle2D.Double[] segments2;

	private transient Timer clock;
	private int counter;
	private boolean[] number;

	public SevenSegment () {
		super();
		segments = new boolean[7];
		segments2 = new RoundRectangle2D.Double[7];
		number = new boolean[4];
		setBackground(Color.BLACK);

		counter = 15;
	}

	public void startCounting() {
		clock = new Timer(1000, this);
		clock.start();
	}

	public void stopCounting() {
		clock.stop();
	}

	public void setValue(int i) {
		counter = i;
		repaint();
	}

	public void actionPerformed(ActionEvent e) {
		counter = counter - 1;
		if (counter < 0) counter = 15;
		repaint();
	}

	public void initializeSegments() {
		int width = getWidth();
		int height = getHeight();

		for (int i = 0; i < 7; i++) segments[i] = false;
		segments2[0] = new RoundRectangle2D.Double(3*width/12,height/12,6*width/12,height/12,10,10);
		segments2[1] = new RoundRectangle2D.Double(9*width/12,2*height/12,width/12,3*height/12,10,10);
		segments2[2] = new RoundRectangle2D.Double(9*width/12,6*height/12,width/12,3*height/12,10,10);
		segments2[3] = new RoundRectangle2D.Double(3*width/12,9*height/12,6*width/12,height/12,10,10);
		segments2[4] = new RoundRectangle2D.Double(2*width/12,6*height/12,width/12,3*height/12,10,10);
		segments2[5] = new RoundRectangle2D.Double(2*width/12,2*height/12,width/12,3*height/12,10,10);
		segments2[6] = new RoundRectangle2D.Double(3*width/12,5*height/12,6*width/12,height/12,10,10);
		repaint();
	}

	public void paintComponent(Graphics g)
	{
		for (int i = 0; i < 4; i++) {
			int mask = (int)Math.pow(2,i);
			number[i] = ((counter & mask) == mask);
		}



		// TO DO: Complete the conditions below.
		// number[] contains the bits of the currently stored number in the form of a boolean array.
		// number[0] is the least significant bit, while number[3] is the most significant bit.


		segments[0] =  !number[0] && (number[1] || number[3] || !number[2]) || number[1] && (!number[3] || number[2])
				|| (!number[1] && !number[2] && number[3]) || (number[0] && number[2] && !number[3]);

		segments[1] = !number[0] && (!number[2] || (!number[1] && !number[3])) || number[0] && ((!number[2] &&
				!number[3]) || (number[1] && !number[3]) || (!number[1] && number[3]));

		segments[2] = number[0] && (!number[2] || !number[1]) || (number[3] && !number[2]) || (!number[1] &&
				!number[3]) || (number[2] && number[1] && !number[3]);


		segments[3] = number[3] && !number[1] || !number[2] && number[1] && !number[3] || number[2] && !number[1] && number[0] || !number[2] && !number[1] && !number[0]|| !number[0] && number[1] && number[2] || number[0] && number[1] && !number[2];


		segments[4] = !number[0] && number[1] || number[3] && number[1] || number[2] && number[3] || !number[2] && !number[0];


		segments[5] = !number[0] && !number[1] || number[3] && number[1] || !number[0] && number[2] || !number[3] && !number[1] && number[2] || !number[2] && number[3];


		segments[6] = number[0] && number[3] || !number[0] && number[1] || number[1] && !number[2] || number[3] && number[0] ||!number[1] && number[2] && !number[3] || number[3] && !number[2];



		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		for (int i = 0; i < 7; i++) {
			if (segments[i]) g2.setColor(Color.RED); else g2.setColor(Color.DARK_GRAY);
			if (segments2[i] != null) g2.fill(segments2[i]);
		}

	}

	public void windowOpened(WindowEvent arg0) {
		
	}

	public void windowClosing(WindowEvent arg0) {
		FileIO writer = new FileIO();
		writer.writeObject("sevenSegmentSave.ssf", this);
	}

	public void windowClosed(WindowEvent arg0) {
		
	}

	public void windowIconified(WindowEvent arg0) {
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}















