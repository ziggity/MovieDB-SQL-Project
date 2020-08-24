package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import entity.Genre;


public class GenreDao {
	//private MovieDao MovieDao;
	//private RatingDao RatingDoa;
	private Connection connection;
	private final String GET_ALL_GENRES = "SELECT * FROM genre order by id";
	//private final String GET_GENRE_QUERY = "SELECT * FROM genre";
	private final String GET_GENRE_BY_ID_QUERY = "SELECT * FROM genre WHERE id = ?";
	private final String CREATE_NEW_GENRE_QUERY = "INSERT INTO genre (genre_name) VALUES(?)";
	private final String DELETE_GENRE_BY_ID_QUERY = "DELETE FROM genre WHERE id = ?";
	private final String UPDATE_GENRE_BY_ID_QUERY = "UPDATE genre SET genre_name = ? WHERE id =?";
	private final String DISPLAY_ALL_MOVIE_BY_GENRE = "SELECT movie.genre_id, movie.movie_title from movie inner join genre on movie.genre_id = genre.id";
	

	public GenreDao() {
		connection = DBConnection.getConnection();
	}
	
	public Genre getGenreById(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(GET_GENRE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return new Genre(rs.getInt(1), rs.getString(2));
		 
	}
	
	public void createNewGenre(String genreName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_GENRE_QUERY);
		ps.setString(1, genreName);
		ps.executeUpdate();
	}
	
	public void updateGenre(int genreId, String updatedGenre) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_GENRE_BY_ID_QUERY);
		ps.setString(1,  updatedGenre);
		ps.setInt(2, genreId);
		System.out.println(ps.toString());
		ps.executeUpdate();
		System.out.println("You have successfully updated!");
	}
		
	public List<Genre> getAllGenre() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_GENRES).executeQuery();
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()) {
			genres.add(populateGenres(rs.getInt(1), rs.getString(2)));
		}
		return genres;
		}

	public List<Genre> displayAllMovieByGenre() throws SQLException{
		ResultSet rs = connection.prepareStatement(DISPLAY_ALL_MOVIE_BY_GENRE).executeQuery();
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()) {
			
			  genres.add(new Genre(rs.getInt(1), rs.getString(2)));

		}
		return genres;
		}

	private Genre populateGenres(int i, String string) {

		return new Genre(i,string);
	}

	public String getGenreNameById(int genres) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_GENRE_BY_ID_QUERY);
		ps.setInt(1, genres);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String genreName = rs.getString(2);
		return genreName;
	}

	public void deleteGenre(int genreIdDelete) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(DELETE_GENRE_BY_ID_QUERY);
		ps.setInt(1, genreIdDelete);
		ps.executeUpdate();
	}
	
}