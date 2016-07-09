/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	//20th Fibonacci number is 6765
    public static long computeFibonacci(long x) {
    	
    	if (x < 0) {
    		throw new IllegalArgumentException(x + "That is a bad value");
    	} else if(x <= 1) {
    		return x;
    	} else {
    		long answer = computeFibonacci(x-2) + computeFibonacci(x-1);
    		return answer;
    	}
	    
    	

    }

    // add a loop, allowing the user to try again on error
	public static void main (String[] args) {
		Scanner kboard = new Scanner (System.in);
		long x = 0;
		try
	    { 
		System.out.println("Which fibonacci number would you like to find? --> ");
		
		x = kboard.nextLong();
		long answer = computeFibonacci(x);
		System.out.println ("The " + x + "th fibonacci number is " + answer + ".");
	    }
		catch ( InputMismatchException ex )
		{ 
			System.err.println ("Thats not a number");
			main(args);
		}
		
    	catch(StackOverflowError z){
    		System.err.println ("That number is too big");
			main(args);
    		
    	}
		catch(IllegalArgumentException z){
    		
			System.err.println ("That number is not an integer");
			main(args);
    		
    	}
		
		
	}

}







