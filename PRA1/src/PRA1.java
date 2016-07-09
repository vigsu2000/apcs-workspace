import java.math.BigInteger;
import java.util.Scanner;

public class PRA1 {
	
	public static boolean isPrime(long x) {
		boolean result = true;
		for(int i=2;i<x;i++) {
	        if(x%i==0) {
	        	result = false;
	        }
	    }
		return result;
	}
	public static void main(String[] args) {		
		Scanner kboard = new Scanner(System.in);
		long n;
		long prod = 1;
		System.out.print("Enter a number: ");
		n = kboard.nextInt();
		for(int x = 2; x < n; x++) {
		    if(isPrime(x)) {
		    	prod = prod * x;
		    }
		}
		if(n == 1) {
			System.out.println(0);
		}
		else {
		BigInteger x = new BigInteger(Long.toOctalString(prod));
		System.out.print(x);
		}
	}
}
