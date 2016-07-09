import java.io.*;
import java.util.*;

/**
 * 
 * This class encrypts and decrypts text files using one of 3 algorithms:
 * 		Random monoalphabet, Vigenere, or Playfair
 * 
 * 
 * @author
 * @version
 * 
 */
public class Crypt {


	/**
	 * 
	 * An integer representing the algorithm chosen.
	 * Set to:
	 * 1 for random monoalphabet
	 * 2 for Vigenere
	 * 3 for Playfair
	 * 
	 */
	public static final int algorithm = 1;
	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");

	public char[] encryptedAlphabet(String keyword, char[] a) {
		char[] encAlph = new char[26];
		String alpha = "";
		for(int e = 0; e < a.length; e++) {
			alpha += a[e];
		}
		StringBuffer word = new StringBuffer(keyword);
		for(int i = word.length()-1; i >= 0; i--) {
			if(word.substring(0, i).contains(word.charAt(i)+"")) {
				word.replace(i, i+1, "");
			}
		}
		StringBuffer alphabet = new StringBuffer(alpha);
		for(int i = 0; i < word.length(); i++) {
			alphabet.deleteCharAt(alphabet.indexOf(word.charAt(i)+""));
		}
		alphabet.reverse();
		char[] key = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			key[i] = word.charAt(i);
		}
		char[] alph = new char[alphabet.length()];
		for(int i = 0; i < alphabet.length(); i++) {
			alph[i] = alphabet.charAt(i);
		}
		for(int i = 0; i < key.length; i++) {
			encAlph[i] = key[i];
		}
		for(int i = 0; i < alph.length; i++) {
			encAlph[key.length+i] = alph[i];
		}
		return encAlph;
	}
	
	public char correctAlphabet(char c, char[] alphabet, char[] encAlphabet) {
		for(int i = 0; i < encAlphabet.length; i++) {
			if(encAlphabet[i] == c) {
				return alphabet[i];
			}
			else if(Character.toUpperCase(encAlphabet[i]) == c) {
				return Character.toUpperCase(alphabet[i]);
			}
		}
		return c;
	}

	public char charToCipher(char c, char[] alphabet, char[] encAlphabet) {
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == c) {
				return encAlphabet[i];
			}
			else if(Character.toUpperCase(alphabet[i]) == c) {
				return Character.toUpperCase(encAlphabet[i]);
			}
		}
		return c;
	}

	/**
	 * Reads from the file specified, and writes out an encrypted version of the file. If the o file already
	 * exists, overwrite it.
	 * 
	 * @param inputFilename The path of the file to be encrypted.
	 * @param outputFilename The path of the encrypted file to be saved.
	 * @param keyword The keyword to be used in the encryption algorithm.
	 * 
	 */
	public void encrypt(String inputFilename, String outputFilename, String keyword) 
	{
		File readFile = new File(inputFilename);
		File writeFile = new File(outputFilename);

		if (!readFile.exists()) {
			System.err.println("File " + inputFilename + " does not exist.");
		}

		Scanner in = null;
		FileWriter writer = null;

		try {

			FileReader reader = new FileReader(readFile);
			writer = new FileWriter(writeFile);

			BufferedReader bReader= new BufferedReader(reader);
			BufferedWriter bWriter = new BufferedWriter(writer);

			in = new Scanner(bReader);

			char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

			char[] encAlphabet = encryptedAlphabet(keyword, alphabet);

			while(in.hasNextLine()) {
				String s = in.nextLine();
				StringBuffer o = new StringBuffer();
				for(int i = 0; i < s.length(); i++) {
					o.append(charToCipher(s.charAt(i), alphabet, encAlphabet));
				}
				//output.append(encryptedChar);
				String sOutput = o.toString();
				bWriter.write(sOutput + lineSeparator);
			}
			bWriter.flush();



		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * Reads from the (previously encrypted) file specified, and writes out a decrypted version of the file. 
	 * If the output file already exists, overwrite it.
	 * 
	 * @param inputFilename The path of the encrypted file.
	 * @param outputFilename The path of the decrypted file to be saved.
	 * @param keyword The keyword to be used in the decryption algorithm.
	 * 
	 */
	public void decrypt(String inputFilename, String outputFilename, String keyword) 
	{
		File readFile = new File(inputFilename);
		File writeFile = new File(outputFilename);

		if (!readFile.exists()) {
			System.err.println("File " + inputFilename + " does not exist.");
		}

		Scanner in = null;
		FileWriter writer = null;

		try {

			FileReader reader = new FileReader(readFile);
			writer = new FileWriter(writeFile);

			BufferedReader bReader= new BufferedReader(reader);
			BufferedWriter bWriter = new BufferedWriter(writer);

			in = new Scanner(bReader);
			StringBuffer word = new StringBuffer(keyword);

			char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

			char[] encAlphabet = encryptedAlphabet(keyword, alphabet);

			while(in.hasNextLine()) {
				String s = in.nextLine();
				StringBuffer o = new StringBuffer();
				for(int i = 0; i < s.length(); i++) {
					o.append(correctAlphabet(s.charAt(i), alphabet, encAlphabet));
				}
				//output.append(encryptedChar);
				String sOutput = o.toString();
				bWriter.write(sOutput + lineSeparator);
			}
			bWriter.flush();



		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				in.close();
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

