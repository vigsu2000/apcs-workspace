import java.sql.Date;
import java.util.ArrayList;

public class Movie {
	private long ID;
	private String title;
	
	private int releaseYear;
	
	private boolean[] genres;
	
	public Movie(long ID, String title, int releaseYear, boolean[] genres) {
		this.ID = ID;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genres = genres;
	}
	public Movie(long ID, String title, boolean[] genres) {
		this.ID = ID;
		this.title = title;
		this.genres = genres;
	}
	
	public String toString() {
		return ID+" "+title+" "+releaseYear+" "+genres[0]+" "+genres[1]+" "+genres[2]+" "+genres[3]
				+" "+genres[4]+" "+genres[5]+" "+genres[6]+" "+genres[7]+" "+genres[8]+" "+genres[9]
						+" "+genres[10]+" "+genres[11]+" "+genres[12]+" "+genres[13]+" "+genres[14]
								+" "+genres[15]+" "+genres[16]+" "+genres[17]+" "+genres[18]+" "+genres[19];
	}
	
	public long getID() {
		return ID;
	}
	
	public boolean[] getAllGenres() {
		return genres;
	}
	
	public int[] getGenres() {
		ArrayList<Integer> trueGenres = new ArrayList<Integer>();
		for(int i = 0; i < genres.length; i++) {
			if(genres[i] == true) {
				trueGenres.add(i);
			}
		}
		Object[] i = trueGenres.toArray();
		int[] arr = new int[i.length];
		for(int a = 0; a < i.length; a++) {
			arr[a] = ((Integer) i[a]).intValue();
		}
		return arr;
	}
	
	public int sameGenre(int[] movieGenres) {
		for(int i = 0; i < movieGenres.length; i++) {
			for(int a = 0; a < getGenres().length; a++) {
				if(movieGenres[i] == getGenres()[a]) {
					return movieGenres[i];
				}
			}
		}
		return 100;
	}

}
