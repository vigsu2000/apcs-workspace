import javax.swing.JOptionPane;

/**
 * 
 * Flow Chart Authored by: VARUN
 * 
 * @author VIGNESH
 * 
 *  + It is a very accurate representation of my flowchart
 *  + It is object oriented
 *  -The method limits the user to using JOptionPane
 *  -You initialized multiple scanners but they're unused (main method)
 *
 */
public class Package {
	private double dim1, dim2, dim3, weight;
	
	public Package(double dim1, double dim2, double dim3, double weight) {
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
	}
	
	public void getStatus() {
		double length = 0;
		double girth = 0;
		String result = "";
		if(dim1 > dim2) {
			if(dim1 > dim3) {
				length = dim1;
				girth = 2 * (dim2 + dim3);
			}
			else {
				length = dim3;
				girth = 2 * (dim1 + dim2);
			}
		}
		else {
			if(dim2 > dim3) {
				length = dim2;
				girth = 2 * (dim1 + dim3);
			}
			else {
				length = dim3;
				girth = 2 * (dim1 + dim2);
			}
		}
		if(length + girth > 100) {
			if(weight > 70) {
				result = "Package is too large and too heavy";
			}
			else {
				result = "Package is too large";
			}
		}
		else {
			if(weight > 70) {
				result = "Package is too heavy";
			}
			else {
				result = "Package is acceptable";
			}
		}
		JOptionPane.showMessageDialog(null, result);
	}

}
