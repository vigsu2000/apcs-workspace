import javax.swing.JOptionPane;

public class CheckMail {
	public static void main(String[] args) {
		
		String a = JOptionPane.showInputDialog("Enter the first dimension of the package: ");
		double dim1 = Double.parseDouble(a);
		
		String b = JOptionPane.showInputDialog("Enter the second dimension of the package: ");
		double dim2 = Double.parseDouble(b);
		
		String c = JOptionPane.showInputDialog("Enter the third dimension of the package: ");
		double dim3 = Double.parseDouble(c);
		
		String d = JOptionPane.showInputDialog("Enter the weight of the package: ");
		double weight = Double.parseDouble(d);
		
		Package pack = new Package(dim1, dim2, dim3, weight);
		pack.getStatus();
		System.exit(0);
	}

}
