
public class Main {
	
	public static void main(String[] args) {
		
		Life game = new Life("life tester.txt");
		System.out.println(game);
		game.step();
	}
}
