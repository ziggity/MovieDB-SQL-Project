
package entity;

import java.util.List;

public class Movie {
	
	private int movieId;
	private String movieTitle;
	private int movieLength;
	private String releaseDate;
	private String director;
	private String leadActor;
	private String revenue;
	private int genres;
	private int ratings;
	
	public Movie (int movieId, String movieTitle, int movieLength, String releaseDate, 
			String director, String leadActor, String revenue, int genres, int ratings) {
		this.setMovieId(movieId);
		this.setMovieTitle(movieTitle);
		this.setMovieLength(movieLength);
		this.setReleaseDate(releaseDate);
		this.setDirector(director);
		this.setLeadActor(leadActor);
		this.setRevenue(revenue);
		this.setGenres(genres);
		this.setRatings(ratings);
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public int getGenres() {
		return genres;
	}

	public void setGenres(int genres) {
		this.genres = genres;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

}
