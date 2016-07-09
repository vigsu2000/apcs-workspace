import java.util.Scanner;

/**
 * Number of Disks to Move:  1      2      3      4      5      6      7      8      9      10 
 * Number of Iterations:     1      3      7      15     31     63    127    255    511    1023 
 * Pattern: 2 * previousNumberOfIterations + 1
 */

public class Hanoi {
	
	public static void hanoi(int nDisks, int fromPeg, int toPeg) {
		if (nDisks == 1) 
		{
			System.out.println(fromPeg + " -> " + toPeg);
	    } else {
	    	int helpPeg = 6 - fromPeg - toPeg;
	        hanoi(nDisks - 1, fromPeg, helpPeg);
	        System.out.println(fromPeg + " -> " + toPeg);
	        hanoi(nDisks - 1, helpPeg, toPeg);
	       }
	}
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter Number of Disks to Move: ");	
		hanoi(kboard.nextInt(), 1, 3);
	}

}
