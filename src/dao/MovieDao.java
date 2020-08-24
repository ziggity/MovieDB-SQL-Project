package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Movie;


public class MovieDao {
	
	private Connection connection;
	private final String CREATE_NEW_MOVIE_QUERY = "INSERT INTO movie(movie_title, movie_length, release_date, director, "
							+ "lead_actor, revenue_made, genre_id, rating_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_MOVIE_BY_ID_QUERY = "UPDATE movie SET movie_title = ?, movie_length = ?, release_date =?, director =?,"
			+ "lead_actor= ?, revenue_made =?, genre_id =?, rating_id=? WHERE id =?";
	private final String DISPLAY_ALL_MOVIES_QUERY = "SELECT * FROM movie";
	private final String DELETE_MOVIE_BY_ID_QUERY = "DELETE FROM movie WHERE id = ?";
	private final String GET_MOVIES_BY_RATING = "SELECT * FROM movie WHERE rating_id=?";
	private final String DISPLAY_ALL_MOVIE_BY_ID = "SELECT * FROM movie WHERE id = ?";

	
	public MovieDao() {
		connection = DBConnection.getConnection();
	}
	
	//1. create a new movie
		public void createMovie(String movieTitle, int movieLength, String releaseDate, String director, 
				String leadActor, String revenueMade, int genreId, int ratingId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MOVIE_QUERY);
			ps.setString(1, movieTitle);
			ps.setInt(2, movieLength);
			ps.setString(3, releaseDate);
			ps.setString(4, director);
			ps.setString(5, leadActor);
			ps.setString(6, revenueMade);
			ps.setInt(7, genreId);
			ps.setInt(8, ratingId);
			int x = ps.executeUpdate();
			System.out.println("You have successfully added " + x + " movie to the list.");
		}
		
	// 2. update a movie
		public void updateMovie(String movieTitle, int movieLength, String releaseDate, String director, 
				String leadActor, String revenue, int genreId, int ratingId, int id) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(UPDATE_MOVIE_BY_ID_QUERY);
			ps.setString(1, movieTitle);
			ps.setInt(2, movieLength);
			ps.setString(3, releaseDate);
			ps.setString(4, director);
			ps.setString(5, leadActor);
			ps.setString(6, revenue);
			ps.setInt(7, genreId);
			ps.setInt(8, ratingId);
			ps.setInt(9, id);
			int updateSuccess = ps.executeUpdate();
			System.out.println("You have successfully updated " + updateSuccess + " movie.");
		}
		
		//2b Update movie - grabbing the movie by id first 
		public List<Movie> getMovieById(int movieId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DISPLAY_ALL_MOVIE_BY_ID);
				ps.setInt(1, movieId);
				ResultSet rs = ps.executeQuery();
			List<Movie> movies = new ArrayList<Movie>();
			while ( rs.next() ) {
				movies.add( populateMovies( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
			}
			return movies;
		}
	
	//3. display all movies
	public List<Movie> getMovie() throws SQLException {
		ResultSet rs = connection.prepareStatement(DISPLAY_ALL_MOVIES_QUERY).executeQuery();
		List<Movie> movies = new ArrayList<Movie>();
		while ( rs.next() ) {
			movies.add( populateMovies( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
		}
		return movies;
	}

	private Movie populateMovies(int movieId, String movieTitle, int movieLength, String releaseDate, String director, String actor, String revenue, int genre, int ratings) {
		// TODO Auto-generated method stub
		return new Movie(movieId, movieTitle, movieLength, releaseDate, director, actor, revenue, genre, ratings);
	}

	//4. delete a movie by id
		public void deleteMovie(int id) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_MOVIE_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		}


	public List<Movie> getMovieByRating(int movieRating) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MOVIES_BY_RATING);
		ps.setInt(1, movieRating);
		ResultSet rs = ps.executeQuery();
		List<Movie> movies = new ArrayList<Movie>();
		while ( rs.next() ) {
			movies.add( populateMovies( rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
		}
		return movies;
	}



}
