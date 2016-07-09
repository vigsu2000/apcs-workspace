import java.util.Arrays;

public class StatisticsCalculator {
	private int[] data;
	private int realLength;
	private static final int MAX_POSSIBLE_VALS = 10000;
	
	public StatisticsCalculator(String fileName) {
		ArrayReader reader = new ArrayReader(fileName);
		data = new int[MAX_POSSIBLE_VALS];
		realLength = reader.fillArray(data);
	}
	
	// 3 methods
	//-----------
	
	// 2) Calculate average of an array
	public double calcAverage() {
		double sum = 0;
		for(int e = 0; e < realLength; e++) {
			sum += data[e];
		}
		return sum/(double)realLength;
	}
	
	// 3) Calculate mode of an array
	public int findMode() {
		int maxCount = 1;
        int maxElement = data[0];
        for( int i = 0; i < realLength; i++ )
        {
            int count = 0;
            for( int j = 0; j < realLength; j++ )
            {
                if( data[i] == data[j] )
                    count++;
            }
            if( maxCount < count )
            {
                maxCount = count;
                maxElement = data[i];
            }
        }
        return maxElement;
		
	}
		
	// 4) Calculate standard deviation of an array
	public double calcStandDev() {
		double av = calcAverage();
		double diff;
		int sum = 0;
		for(int e = 0; e < realLength; e++) {
			diff = Math.abs(data[e]-av);
			diff = diff * diff;
			sum += diff;
		}
		double div = sum/realLength;
		double sqrt = Math.sqrt(div);
		return sqrt;
	}
	
	public void compact(){
		int t1 = 0;
		int t2 = 0;
		while (t1 <= realLength - 1) { 
			if (data[t1] != 0) { 
				data[t2++] = data[t1]; 
			}
			t1++;
		}
		while (t2 <= realLength - 1) {
			data[t2++] = 0;
		}
		int a = 0;
		while(data[a] != 0) {
			System.out.print(data[a] + " ");
			a++;
		}
		realLength = realLength - (realLength - a);
		System.out.println();
	}

	
	public static void main(String[] args) {
		StatisticsCalculator calc1 = new StatisticsCalculator("numbers.txt");
		StatisticsCalculator calc2 = new StatisticsCalculator("numbers2.txt");
		StatisticsCalculator calc3 = new StatisticsCalculator("numbers3.txt");
		StatisticsCalculator calc4 = new StatisticsCalculator("numbers4.txt");
		calc1.compact();
		calc2.compact();
		calc3.compact();
		calc4.compact();
		System.out.println(calc1.calcAverage());
		System.out.println(calc1.calcStandDev());
		System.out.println(calc1.findMode());
		System.out.println(calc2.calcAverage());
		System.out.println(calc2.calcStandDev());
		System.out.println(calc2.findMode());
		System.out.println(calc3.calcAverage());
		System.out.println(calc3.calcStandDev());
		System.out.println(calc3.findMode());
		System.out.println(calc4.calcAverage());
		System.out.println(calc4.calcStandDev());
		System.out.println(calc4.findMode());
	}
}