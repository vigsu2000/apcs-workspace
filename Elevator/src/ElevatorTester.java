
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;


public class ElevatorTester extends JPanel implements ActionListener,WindowListener{

	private JButton[] buttons;
	private JButton act;
	private JButton save;
	private Elevator theElevator;

	public ElevatorTester() {
		super(new BorderLayout());

		buttons = new JButton[3];
		buttons[0] = new JButton("1");
		buttons[1] = new JButton("2");
		buttons[2] = new JButton("3");
		act = new JButton("ACT");
		save= new JButton("Save");
		
		theElevator=Elevator.loadState("elevator.ssf");
		
		if(theElevator!=null)
		{
			theElevator.initializeGUI(act,buttons);
			theElevator.act();
		}else{
			theElevator = new Elevator(act,buttons);
		}
		for(JButton b : buttons)
			b.setBackground(Color.LIGHT_GRAY);

		add(theElevator, BorderLayout.CENTER);

		JPanel right = new JPanel(new GridLayout(1,2));
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();

		JPanel r = new JPanel(new GridLayout(0,2));
		JPanel but = new JPanel();


		JPanel rL = new JPanel(new GridLayout(0,2));

		JPanel buttonBox = new JPanel(new GridLayout(3,1));
		for (int i = 2; i >= 0; i--) {
			JButton b = buttons[i];
			b.addActionListener(this);
			buttonBox.add(b);
		}
		top.add(buttonBox);
		right.add(top);

		act.addActionListener(this);
		bottom.add(act);
		right.add(act);

		save.addActionListener(this);
		but.add(save);
		r.add(save);





		add(right, BorderLayout.NORTH);
		add(rL,BorderLayout.WEST);
		add(r,BorderLayout.SOUTH);

		
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == buttons[i]) {
				theElevator.pushButton(i);
				return;
			}
		}
		if (e.getSource() == act) {
			theElevator.act();
		}
		if(e.getSource()==save)
		{
			Elevator.saveState(theElevator, "elevator.ssf");
		}
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {

		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {

		// TODO Auto-generated method stub

	}
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Elevator Simulation");
		w.setBounds(100, 100, 480, 640);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ElevatorTester panel = new ElevatorTester();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		w.addWindowListener(panel);
	}

}
