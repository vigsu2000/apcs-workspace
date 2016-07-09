import java.io.FileNotFoundException;
import java.util.ArrayList;


public class NetFlixPredictor {


	// Add fields to represent your database.
	private ArrayList<User> userDatabase;
	private ArrayList<Movie> movieDatabase;
	private ArrayList<Rating> ratingDatabase;


	
	/**
	 * 
	 * Use the file names to read all data into some local structures. If any other database files are used,
	 * make sure they are stored in your Eclipse project and hardcode their location.
	 * 
	 * @param ratingsFilename The filename of the ratings database.
	 * @param usersFilename The filename of the users database.
	 * @param moviesFilename The filename of the movies database.
	 */
	public NetFlixPredictor(String ratingsFilename, String usersFilename, String moviesFilename) {
		FileIO reader = new FileIO();
		ArrayList<String> userFileData = reader.readFile(usersFilename);
		ArrayList<String> movieFileData = reader.readFile(moviesFilename);
		ArrayList<String> ratingFileData = reader.readFile(ratingsFilename);
		
		
		userDatabase = new ArrayList<User>();
		movieDatabase = new ArrayList<Movie>();
		ratingDatabase = new ArrayList<Rating>();
		
		
		for (String s : userFileData) {
			User newUser = MovieLens100kTranslator.lineToUser(s);
			userDatabase.add(newUser);
		}
		for (String s : movieFileData) {
			Movie newMovie = MovieLens100kTranslator.lineToMovie(s);
			movieDatabase.add(newMovie);
		}
		for (String s : ratingFileData) {
			Rating newRating = MovieLens100kTranslator.lineToRating(s, userDatabase, movieDatabase);
			ratingDatabase.add(newRating);
		}
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		return movieDatabase.toArray();
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		return userDatabase.toArray();
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {
		for(int i = 0; i < ratingDatabase.size(); i++) {
			if(ratingDatabase.get(i).getUser().getID() == userID && 
					ratingDatabase.get(i).getMovie().getID() == movieID) {
				return ratingDatabase.get(i).getStars();
			}
		}
		return -1;
	}
	
	public static User binarySearchUser(ArrayList<User> database, long ID) {
		return binarySearchUser(database, ID, 0, database.size()-1);
	}
	
	public static User binarySearchUser(ArrayList<User> database, long ID, int start, int end) {
		int index = (start+end)/2;
		User u = database.get(index);
		if(u.getID() == ID) {
			return u;
		}
		else if(start==1) {
			return null;
		}
		else if(u.getID() > ID) {
			return binarySearchUser(database, ID, start, index-1);
		}
		else {
			return binarySearchUser(database, ID, index+1, end);
		}
	}
	
	public static Movie binarySearchMovie(ArrayList<Movie> database, long ID) {
		return binarySearchMovie(database, ID, 0, database.size()-1);
	}
	
	public static Movie binarySearchMovie(ArrayList<Movie> database, long ID, int start, int end) {
		int index = (start+end)/2;
		Movie u = database.get(index);
		if(u.getID() == ID) {
			return u;
		}
		else if(start==1) {
			return null;
		}
		else if(u.getID() > ID) {
			return binarySearchMovie(database, ID, start, index-1);
		}
		else {
			return binarySearchMovie(database, ID, index+1, end);
		}
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {
		ArrayList<Rating> sameGenre = new ArrayList<Rating>();
		int[] g = binarySearchMovie(movieDatabase, movieID).getGenres();
		for(int i = 0; i < ratingDatabase.size(); i++) {
			if(ratingDatabase.get(i).getUser().getID() == userID && ratingDatabase.get(i).getMovie().sameGenre(g) != 100) {
				sameGenre.add(ratingDatabase.get(i));
			}
		}
		if(getRating(userID, movieID) != -1) {
			return getRating(userID, movieID);
		}
		else {
			double totalStars = 0;
			for(int a = 0; a < sameGenre.size(); a++) {
				totalStars += sameGenre.get(a).getStars();
			}
			if(totalStars != 0) {
				return totalStars/sameGenre.size();
			}
			else {				
				User u = null;
				for (int i = 0; i < ratingDatabase.size(); i++) {
					u = ratingDatabase.get(i).getUser();
					User otherU = binarySearchUser(userDatabase, userID);
					if(Math.abs(u.getAge()-otherU.getAge()) <= 5 && 
							u.getGender() == otherU.getGender()) {
						Movie m = ratingDatabase.get(i).getMovie();
						int[] genres = m.getGenres();
						if(binarySearchMovie(movieDatabase, movieID).sameGenre(genres) != 100) { {
							return ratingDatabase.get(i).getStars();
						}
						}
					}
				}
			}
		}
		return 3.33;
	}
}
	

