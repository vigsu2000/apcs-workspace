import java.util.ArrayList;

public class MovieLens100kTranslator {
	
	public static User lineToUser(String line) {
		// Parse the String line to get out each piece of data
		// Create a User object, passing in the data
		// return that object
		int one = line.indexOf("|");
		int two = line.indexOf("|", one+1);
		int three = line.indexOf("|", two+1);
		int four = line.indexOf("|", three+1);
		User u = new User((long)(Integer.parseInt(line.substring(0, one))), 
				Integer.parseInt(line.substring(one+1, two)), 
				line.charAt(two+1), 
				line.substring(three+1, four), 
				line.substring(four+1, line.length()));
		return u;
	}
	
	public static Movie lineToMovie(String line) {
		int one = line.indexOf("|");
		int two = line.indexOf("|", one+1);
		int three = line.indexOf("|", two+1);
		int four = line.indexOf("|", three+2);
		long ID = (long)(Integer.parseInt(line.substring(0, one)));
		String title = line.substring(one+1, two-7);
		boolean hasReleaseYear = true;
		int releaseYear = 0;
		try {
			releaseYear = Integer.parseInt(line.substring(three-4, three));
		} catch(NumberFormatException ex) {
			hasReleaseYear = false;
		}
		String str = line.substring(four);
		String[] g = str.split("\\|");
		boolean[] genres = new boolean[20]; 
		for(int e = 0; e < g.length; e++) {
			if(g[e].equals("1")) {
				genres[e] = true;
			} else {
				genres[e] = false;
			}
		}
		Movie m = new Movie(ID, title, genres);
		if(hasReleaseYear) {
			m = new Movie(ID, title, releaseYear, genres);
		}
		else {
			m = new Movie(ID, "unknown", genres);
		}
		return m;
	}
	
	public static Rating lineToRating(String line, ArrayList<User> users, ArrayList<Movie> movies) {
		User user = null;
		Movie movie = null;
		int i = 0;
		while(Character.isLetterOrDigit(line.charAt(i))) {
			i++;
		}
		long userID = Integer.parseInt(line.substring(0, i));
		for(int e = 0; e < users.size(); e++) {
			if(users.get(e).getID() == userID) {
				user = users.get(e);
			}
		}
		while(!Character.isLetterOrDigit(line.charAt(i))) {
			i++;
		}
		int movieStart = i;
		while(Character.isLetterOrDigit(line.charAt(i))) {
			i++;
		}
		int movieEnd = i;
		long movieID = Integer.parseInt(line.substring(movieStart, movieEnd));
		for(int e = 0; e < movies.size(); e++) {
			if(movies.get(e).getID() == movieID) {
				movie = movies.get(e);
			}
		}
		while(!Character.isLetterOrDigit(line.charAt(i))) {
			i++;
		}
		int starsStart = i;
		while(Character.isLetterOrDigit(line.charAt(i))) {
			i++;
		}
		int starsEnd = i;
		double stars = Double.parseDouble(line.substring(starsStart, starsEnd));
		Rating r = new Rating(user, movie, stars);
		return r;
	}
}
