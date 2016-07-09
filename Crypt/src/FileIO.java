import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileIO {

	//public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");

	public ArrayList<String> readFile(String filename) {

		File readFile = new File(filename);
		if (!readFile.exists()) {
			System.err.println("File " + filename + " does not exist.");
			return null;
		}

		Scanner in = null;

		try {

			FileReader reader = new FileReader(readFile);
			BufferedReader bReader =new BufferedReader(reader);

			in = new Scanner(bReader);

			ArrayList<String> fileData = new ArrayList<String>();

			while (in.hasNextLine()) {
				String input = in.nextLine();
				fileData.add(input);
			}
			return fileData;

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (in != null)
				in.close();

		}

	}
	public void writeFile(String filename, ArrayList<String> data) {

		File writeFile = new File(filename);
		FileWriter writer = null;

		try {

			writer = new FileWriter(writeFile);
			BufferedWriter bWriter= new BufferedWriter(writer);

			for (String s : data) {
				bWriter.write(s + lineSeparator);
			}

			bWriter.flush();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}