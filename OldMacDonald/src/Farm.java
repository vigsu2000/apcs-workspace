
import java.util.ArrayList;

public class Farm{
	private ArrayList<Animal> myFarm = new ArrayList<Animal>();

	public Farm(){
		myFarm.add(new Cow());
		myFarm.add(new Chick());
		myFarm.add(new Pig());
	}

	// This method prints out the result of each animal's toString() method to the command
	// line window.
	public void printAnimalSounds(){
		for(int i = 0; i < myFarm.size(); i++) {
			System.out.println(myFarm.get(i));
		}
	}

	// This method prints out the lyrics to OldMacDonald, including all animals in the farm.
	public void printOldMacDonaldSong() {
		for(int i = 0; i < myFarm.size(); i++) {
			System.out.println("Old MacDonald had a farm,");
			System.out.println("E-I-E-I-O");
			System.out.println();
			System.out.println("And on his farm he had some " + myFarm.get(i).getType() + "s,");
			System.out.println("E-I-E-I-O");
			System.out.println();
			System.out.println("With a " + myFarm.get(i).getSound() + ", " + myFarm.get(i).getSound() + " here,");
			System.out.println("And a " + myFarm.get(i).getSound() + ", " + myFarm.get(i).getSound() + " there,");
			System.out.println("Here a " + myFarm.get(i).getSound() + ", there a " +  myFarm.get(i).getSound() + ",");
			System.out.println("Everywhere a " + myFarm.get(i).getSound() + ", " + myFarm.get(i).getSound() + ",");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Farm f = new Farm();
		f.printOldMacDonaldSong();
	}
}
