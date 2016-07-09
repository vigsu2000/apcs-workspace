import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*

	This program erases objects (connected stars) from a 2D grid. 

	Coded by: 
	Modified on: 

*/

public class Erase {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;

	// Constructs an empty grid
	public Erase() {
	}

	// Constructs the grid defined in the file specified
	public Erase(String filename) {
		data = readData(filename);
	}
	
	// Erases an object beginning at x,y
	public void eraseObject(int x, int y) {
		if(x < 0 || x > data.length) {}
		if(data[x][y] == 32) {}
		else {
			data[x][y] = 32;
			eraseObject(x, y-1);
			eraseObject(x, y+1);
			eraseObject(x-1, y);
			eraseObject(x+1, y);
		}
		//Am I off the grid? (base case)
			//do nothing
		//Is there no object at this location? (base case)
			//do nothing
		//Otherwise:
			//clear this spot
			//recursive call up
			//recursive call down
			//recursive call left
			//recursive call right
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String output = "";
		for(int j = 0; j < data[0].length; j++) {
			for(int i = 0; i < data.length; i++) {
				data[i][j] += "";
			}
		}
		return output;
	}

	public char[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			char[][] gameData = new char[rows][cols];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							gameData[count][i] = line.charAt(i);

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