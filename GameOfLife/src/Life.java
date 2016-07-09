import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Represents a Game Of Life grid.

	Coded by:
	Modified on:

*/

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;
	private boolean[][] grid;
	private boolean[][] gridClone;

	// Constructs an empty grid
	public Life() {
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = readData(filename);
		gridClone = grid;
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(gridClone[j][i] == true) {
					int neighbors = countNeighbors(i, j);
					if(neighbors != 2 || neighbors != 3) {
						grid[j][i] = false;
					}
				}
				else {
					if(countNeighbors(i, j) == 3) {
						grid[j][i] = true;
					}
				}
			}
		}
		gridClone = grid;
	}
	
	private int countNeighbors(int i, int j) {
		int count = 0;
		for(int a = Math.max(i-1, 0); a <= Math.min(i+1, grid.length-1); a++) {
			for(int b = Math.max(j-1, 0); b <= Math.min(i+1, grid[i].length-1); b++) {
				if(gridClone[b][a] == true || gridClone[b][a] == false) {
					if(gridClone[b][a] == true) {
						count = count +1;
					}
				}
			}
		}
		if(gridClone[j][i] == true) {
			return count - 1;
		}
		return count;
	}



	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i = 0; i < n; i++) {
			step();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for(int j = 0; j < grid[0].length; j++) {
			for(int i = 0; i < grid.length; i++) {
				if(grid[i][j]) 
				output += "*";
				else
					output += " ";
			}
			output += "\n";
		}
		return output;
	}

	public boolean[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			boolean[][] gameData = new boolean[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (line.charAt(i)=='*')
								gameData[i][count] = true;

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}