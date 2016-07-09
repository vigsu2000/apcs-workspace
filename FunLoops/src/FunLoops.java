
/**
 * Number of magic squares (n): 1           2           3           4           5           6           7           8           9          10
 * Runtime (nanoseconds):     343599      114615      517430     13486238   24748208     271200874  5774475660 207663061152     ?          ?
 * @author VIGNESH
 *
 *
 * Fibonacci Timing Data:     10          20          30          40          45
 * Recursive (nanoseconds):  28985      902970     9322412     753180870  6848955231
 * Looping (nanoseconds):    2565        1324        1129        1510        1425  
 * 
 * 		The looping version is significantly faster than the recursive version. I think that this 
 * is because the recursive version has to call the method method a very large number of times, 
 * which is why it takes so much time. Also, the recursive method has to check for the first base 
 * case every single time even though most of the time the condition is false. The number of 
 * iterations in the looping version is always 1 because when run, it is simply calling the method. 
 * The number of iterations in the recursive one steadily increases because each time the method is 
 * called, multiple recursive calls are made. The greater number of iterations in the recursive 
 * version is most likely the reason why the timing data shows that it is much slower than the 
 * looping version
 * 
 * 
 * 
 * 
 * Fibonacci Iterations Data:  1      2      3      4      5      6      7      8      9      10
 * Num. of Iters. (recursive): 1      3      5      9      15     25     41     67    109     177
 * Num. of Iters. (looping):   1      1      1      1      1      1      1      1      1       1
 */

public class FunLoops {
	
	public static long factorial(long n) {
		if(n == 0) {
			return 1;
		}
		else {
			long prevFact = factorial(n-1);
			return n * prevFact;
		}
	}
	
	public static long fibonacci(long n) {
		if(n == 0 || n == 1) {
			return n;
		}
		else {
			long result = fibonacci(n-1) + fibonacci(n-2);
			return result;
		}
	}
	
	/*
	 * 1. currNum should begin on 1 (fibonacci(2) = 1)
	 * 2. before shifting (which is what you currently are doing) you should make the current num 
	 * equal to the sum of the two previous numbers;
	 */
	public static long fibonacci2(long n) {
		long prev2 = 0;
		long prev1 = 0;
		long currNum = 1;
		for(int i = 0; i < n; i++) {
			prev2 = prev1;
			prev1 = currNum;
			currNum = prev1 + prev2;
		}
		return prev1;
	}
	
	public static long LCM(long x, long y) {
		long a;
		long small;
		long large;
		if(x > y) {
			a = x;
			small = y;
			large = x;
		}
		else {
			a = y;
			small = x;
			large = y;
		}
        while(true)
        {
            if(a % small == 0)
                return a;
            a += large;
        }	
	}
	
	public static void magicSquares(int n) {
		if(n == 1) {
			System.out.println(1);
		}
		else {
			System.out.println(1);
			int x = 1;
			double y = 1;
			double p = 0;
			double t = 0;
			while(x < n){ 
				t = 0;
				p = 0;
				y++;
				while(x < n){
					if (t == Math.pow(y, 2)){	
						System.out.println((int)Math.pow(y, 2));
						x++;
						break;
					}
					else{
						p++;	
						t += p; 
						if(t / 2 > Math.pow(y, 2)){
							break;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("LCM Test Cases:");
		System.out.println(LCM(15, 18));
		System.out.println(LCM(40, 12));
		System.out.println(LCM(2, 7));
		System.out.println(LCM(100, 5));
		System.out.println();
		System.out.println("Magic Square Test Cases:");
		magicSquares(4);
	}

}
