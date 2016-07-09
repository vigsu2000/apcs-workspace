import java.util.Scanner;


public class RecursiveStringTools {
	
	// Example given in reading
	static int length( String str )
	{
	  if (str.length() == 0) {
	    return 0;
	  }
	  else {
	    return 1 + length(str.substring(1));
	  }
	}
	
	
	// Example given in reading	
	public static boolean myEquals( String strA, String strB )
	  {
		if ( strA.isEmpty() && strB.isEmpty() ) 
		      return true;
		    else if ( strA.isEmpty() || strB.isEmpty() ) 
		      return false;
		    else if ( strA.charAt(0) != strB.charAt(0) || strA.charAt(0) != strB.charAt(0))
		      return false;
		    else
		      return myEquals( strA.substring(1), strB.substring(1));
	  }
	


	// Example given in reading
	public static String reverse( String str )
	  {
	    if ( str.isEmpty() )       // use str.equals("") for older version of Java 
	      return "";
	    else 
	      return reverse( str.substring(1) ) + str.charAt(0) ;
	  }
	

	
	// Exercise #1
	public boolean matches(String strA, String strB) {
		strA = strA.replaceAll("[^a-zA-Z]", "");
		strB = strB.replaceAll("[^a-zA-Z]", "");
		boolean result = true;
		if ( strA.isEmpty() && strB.isEmpty() ) {
			result = true;
		}
		if(strA.charAt(0) == '?' || strB.charAt(0) == '?') {
			result = true;
		}
		else if ( strA.isEmpty() || strB.isEmpty() ) {
			return false;
		}
		else if ( strA.charAt(0) != strB.charAt(0) ) {
			return false;
		}
		else {
			return matches(strA.substring(1), strB.substring(1));
		}
		return result;
	}
	
	// Exercise #2
	public boolean isPalindrome(String in) {
		in = in.replaceAll(" ", "");
		in = in.toLowerCase();
		in = in.replaceAll("[^a-zA-Z]", "");
		if(in.isEmpty()) {
			return true;
		}
		else {
			if(!Character.isLetterOrDigit(in.charAt(0)) && !Character.isLetterOrDigit(reverse(in).charAt(0))) {
				return myEquals(in.substring(2), reverse(in).substring(2));
			}
			else if(!Character.isLetterOrDigit(in.charAt(0))) {
				return myEquals(in.substring(2), reverse(in).substring(1));
			}
			else if(!Character.isLetterOrDigit(reverse(in).charAt(0))) {
				return myEquals(in.substring(1), reverse(in).substring(2));
			}
			else {
				return myEquals(in.substring(1), reverse(in).substring(1));
			}
		}
	}

	// Exercise #3
	public void printPermutations(String in, String prefix) {
		// Base case:
			// Length of in is 1 -> print out the prefix + in
		// Recursive case:
			// Call loop with in and the prefix. Start i at 0.
		if(in.length() == 1) {
			System.out.println(prefix + in);
		}
		else {
			loop(in, prefix, 0);
		}
	}
	
	private void loop(String in, String prefix, int i) {
		// Lengthen the prefix by taking prefix and adding the char at i
		// Make in smaller by removing the char at i
		// Call printPermutations with the new in and new prefix.
		// Add one to i
		
		// Base case:
			// if i is greater than or equal to the length of in -> do nothing
		// Recursive case:
			// Call loop with the original in, original prefix, and i
		String newPrefix = prefix + in.charAt(i);
		String newIn1 = in.substring(0, i); 
		String newIn2 = in.substring(i+1);
		String newIn = newIn1 + newIn2;
		printPermutations(newIn, newPrefix);
		if(i >= newIn.length()) {
			return;
		}
		else {
			loop(in, prefix, i+1);
		}
	}
	
	public String pigLatinateWord(String s) {
		s = s.replaceAll("[^a-zA-Z]", "");
		System.out.println(s);
		if(s.charAt(0) == 'a' || s.charAt(0) == 'A' || 
		s.charAt(0) == 'e' || s.charAt(0) == 'E' || 
		s.charAt(0) == 'i' || s.charAt(0) == 'I' || 
		s.charAt(0) == 'o' || s.charAt(0) == 'O' || 
		s.charAt(0) == 'u' || s.charAt(0) == 'U') {
			return s + "yay";
		}
		else {
			boolean vowPresent = false;
			int vowLoc = 0;
			for(int i = 1; i < s.length(); i++) {
				if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || 
				s.charAt(i) == 'e' || s.charAt(i) == 'E' || 
				s.charAt(i) == 'i' || s.charAt(i) == 'I' || 
				s.charAt(i) == 'o' || s.charAt(i) == 'O' || 
				s.charAt(i) == 'u' || s.charAt(i) == 'U') {
					vowPresent = true;
					vowLoc = i;
					break;
				}
			}
			if(vowPresent == false) {
				return s + "ay";
			}
			else {
				String start = s.substring(0, vowLoc);
				String end = s.substring(vowLoc, s.length());
				if(isUpperCase(s)) {
					end = end.toUpperCase();
					start = start.toLowerCase();
				}
				return end + start + "ay";
			}
		}
	}
	
	public String pigLatinateSentence(String s) {
		if (s.length() == 0) {
			   return s;
			    }
		else {
			return (pigLatinateWord(s.substring(0, s.indexOf(' ') )) + " "
				+ pigLatinateSentence(s.substring(s.indexOf(' ') + 1)));        
		}
	}
	
	public String pigLatinate(String s) {
		s = s.replaceAll("[^a-zA-Z]", " ");
		s = s.trim();       
	    s += " ";        	                      
	    s = pigLatinateSentence(s);
	    s = s.trim();    
	    return s;    
	}
	
	public boolean isUpperCase(String str) {
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c >= 97 && c <= 122) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string!");
		String s = kboard.nextLine();
	
		RecursiveStringTools runner = new RecursiveStringTools();
		runner.printPermutations(s, "");
		//System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
