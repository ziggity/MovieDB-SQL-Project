package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Genre;
import entity.Rating;

public class RatingDao {
	
	private Connection connection; 
	private final String CREATE_NEW_RATING = "INSERT INTO rating (rating_scale) VALUE (?)";
	private final String GET_ALL_RATINGS = "SELECT * FROM rating";
	private final String DELETE_RATING = "DELETE FROM rating WHERE id = ?";
	private final String UPDATE_RATING = "UPDATE rating SET rating_scale = ? WHERE id = ?";
	private final String GET_RATING_BY_ID = "SELECT * FROM rating WHERE id = ?";
	
	public RatingDao() {
		connection = DBConnection.getConnection();
	}

	public void createNewRating(String ratingScale) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_RATING);
		ps.setString(1, ratingScale);
		ps.executeUpdate();
		System.out.println("You have successfully added " + ratingScale + " to the list of possible ratings.");
	}
		

	public void updateRatingById(int ratingId, String updatedRating) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RATING);
		ps.setString(1, updatedRating);
		ps.setInt(2, ratingId);
		ps.executeUpdate();
		
	}

	public List<Rating> getAllRatings() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_RATINGS).executeQuery();
		List<Rating> ratings = new ArrayList<Rating>();
		while(rs.next()) {
			ratings.add(populateRatings(rs.getInt(1), rs.getString(2)));
		}
		return ratings;
		}

	private Rating populateRatings(int int1, String string) {
		
		return new Rating(int1, string);
	}

	public void deleteARating(int deleteRating) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_RATING);
		ps.setInt(1, deleteRating);
		ps.executeUpdate();
		System.out.println("Your rating was deleted.");
	}

	public String getRatingById(int ratings) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_RATING_BY_ID);
		ps.setInt(1, ratings);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String ratingName = rs.getString(2);
		return ratingName;
	}
}
	

