
public class Rating {
	
	private User user;
	
	private Movie movie;
	
	private double stars;
	
	public Rating(User user, Movie movie, double stars) {
		this.user = user;
		this.movie = movie;
		this.stars = stars;
	}
	
	public User getUser() {
		return user;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public double getStars() {
		return stars;
	}

}
