
public class Tester {
	public static void main(String[]args) {
		int bank = 3000;
    	int car = 4000;
    	int hours = 0;
    	while (bank < car){
      	hours++;
      	bank += 12;
    	}
    	System.out.println("You worked " + hours 
		+ " hours to buy your car!");
	}
}
