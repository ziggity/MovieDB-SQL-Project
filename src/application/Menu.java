package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Dao.GenreDao;
import Dao.MovieDao;
import Dao.RatingDao;
import Entity.Movie;
import Entity.Genre;
import Entity.Rating;

import Dao.MovieDao;

public class Menu {

	private GenreDao genreDao = new GenreDao();
	private MovieDao movieDao = new MovieDao();
	private RatingDao ratingDao = new RatingDao();

	Scanner intScanner = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Create a movie",
			"Update a movie by id",
			"Display a list of all movies", 
			"Delete a movie by id", 
			"Create a genre",
			"Update a genre by id",
			"Display all movies by genre",
			"Delete a genre by id",
			"Update rating",
			"Display all movies by rating",
			"Create new rating",
			"Delete a rating",
			"Show all Genre",
			"Close App");
	
	public void start() throws SQLException {
		
		String userSelection = "";
		
		do {
			
			displayMenu();
			userSelection = scanner.nextLine();
			
			if ( userSelection.equals("1") ) {
				createMovie();
			} else if ( userSelection.equals("2") ) {
				updateMovie();
			} else if ( userSelection.equals("3") ) {
				displayAllMovies();
			} else if ( userSelection.equals("4") ) {
				deleteMovie();
			} else if ( userSelection.equals("5") ) {
				createGenre();
			} else if ( userSelection.equals("6") ) {
				updateGenre();
			} else if ( userSelection.equals("7") ) {
				displayAllMoviesByGenre();
			} else if ( userSelection.equals("8") ) {
				deleteGenre();
			} else if ( userSelection.equals("9") ) {
				updateRating();
			} else if ( userSelection.equals("10") ) {
				displayAllMoviesByRating();
			} else if ( userSelection.equals("11") ) {
				createNewRating();
			} else if ( userSelection.equals("12") ) {
				deleteRating();
				
			} else if ( userSelection.equals("0") ) {
				displayAllGenre();
			} else if ( userSelection.equals("0") ) {
				closeApp();
			} 
			
			System.out.println("Press enter to continue....\n ");
			scanner.nextLine();
			
		} while (!userSelection.equals("0"));
		
	}

	

	private void displayMenu() {
		
		System.out.println("Select an option: \n------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			if ( i == options.size()-1 ) {
				System.out.println("0) " + options.get(i));
			} else {
				System.out.println((i+1) + ") " + options.get(i));
			}
		}
		
	}
	
	// Need to finish and potential add more methods 
	private void closeApp() {
		System.out.println("\n\n---------------------------------------\n");
		System.out.println("Thank you for using the application");
		System.exit(0);
	}
	
	private void createMovie() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter the movie title: \n");
		String movieTitle = scanner.nextLine();
		System.out.println("Enter the total length in minutes: \n");
		int movieLength = intScanner.nextInt();
		System.out.println("Enter the release date: \n");
		String releaseDate = scanner.nextLine();
		System.out.println("Enter movie's director: \n");
		String director = scanner.nextLine();
		System.out.println("Enter movie's actor: \n");
		String actor = scanner.nextLine();
		System.out.println("Enter movie's revenue earned: \n");
		String moneyMade = scanner.nextLine();
		System.out.println("Select the movies genre: \n");
		displayAllGenres();
		int genreId = intScanner.nextInt();
		System.out.println("Enter a 1 to 5 star rating: \n");
		int ratingId = intScanner.nextInt();
		
		movieDao.createMovie(movieTitle, movieLength, releaseDate, director, actor, moneyMade, genreId, ratingId);
	}

	private void updateMovie() throws SQLException {
		String title = "";
		int length = 0;
		String date = "";
		String director2 = "";
		String actor2 = "";
		String money = "";
		int genreId2 = 0;
		int ratingId2 = 0; 
		
		System.out.println("Enter the id of the movie you would like to update: \n");
		int movieId = intScanner.nextInt();
		List<Movie> movies = movieDao.getMovieById(movieId);
		for ( Movie m : movies ) {
			//Updating Movie Title
			System.out.println("The movie title is: " + m.getMovieTitle() + " \n"
					+ "Do you want to change the title? Enter y/n: ");
			String change = scanner.nextLine();
			if ( change.equals("y") ) {
				System.out.println("Enter the NEW title: ");
				title = scanner.nextLine();
			} else {
				title = m.getMovieTitle();
			}
			
			//Updating movie length
			System.out.println("The movie length is (in minutes): " + m.getMovieLength() + " \n"
					+ "Do you want to change the length? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW length: ");
				length = intScanner.nextInt();
			} else {
				length = m.getMovieLength();
			}
			
			//Updating movie release date
			System.out.println("The movie release date is: " + m.getReleaseDate() + " \n"
					+ "Do you want to change the release date? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW date (format: yyyy-mm-dd): ");
				date = scanner.nextLine();
			} else {
				date = m.getReleaseDate();
			}
			
			//Updating movie director
			System.out.println("The movie's director is: " + m.getDirector() + " \n"
					+ "Do you want to change the director? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW director: ");
				director2 = scanner.nextLine();
			} else {
				director2 = m.getDirector();
			}
			
			//Updating movie actor
			System.out.println("The movie's main actor is: " + m.getLeadActor() + " \n"
					+ "Do you want to change the actor? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW lead actor: ");
				actor2 = scanner.nextLine();
			} else {
				actor2 = m.getLeadActor();
			}
			
			//Updating movie revenue
			System.out.println("The movie's current earnings are: " + m.getRevenue() + " \n"
					+ "Do you want to change the revenue amount? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW revenue amount ( format : $xxx,xxx,xxx.xx): ");
				money = scanner.nextLine();
			} else {
				money = m.getRevenue();
			}
			
			//Updating movie genre
			System.out.println("The movie's genre is : " + m.getGenres() + " \n"
					+ "Do you want to change the genre? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("Enter the NEW genre: ");
				displayAllGenres();
				genreId2 = intScanner.nextInt();
			} else {
				genreId2 = m.getGenres();
			}
			
			//Updating movie rating
			String ratingName = ratingDao.getRatingById(m.getRatings());
			System.out.println("The movie's rating is : " + ratingName + " \n"
					+ "Do you want to change the rating? Enter y/n: ");
			change = scanner.nextLine();
			if ( change.contentEquals("y") ) {
				System.out.println("\nThe current list of ratings: ");
				displayAllRatings();
				System.out.println("Enter the NEW rating number: ");
				ratingId2 = intScanner.nextInt();
			} else {
				ratingId2 = m.getRatings();
			}
		} // end for loop
		
		movieDao.updateMovie(title, length, date, director2, actor2, money, genreId2, ratingId2, movieId);
		
	}
	
	//displays all movies with all of their information
	//format still?
	private void displayAllMovies() throws SQLException {
		System.out.printf("%-22s %-8s %-11s %-22s %-22s %-18s %-13s %-20s \n", 
				"Movie Title: ", "Length: ", "Released: ", "Director: ",
				"Lead Actor: ", "Revenue: ", "Movie Genre: ", "Movie Rating: ");
		String dash = "-".repeat(150);
		System.out.println(dash);
		List<Movie> movies = movieDao.getMovie(); 
		String genreName = "";
		String ratingName = "";
		for ( Movie m : movies ) {
			genreName = genreDao.getGenreNameById(m.getGenres());
			ratingName = ratingDao.getRatingById(m.getRatings());
			System.out.printf("%-22s %-8d %-11s %-22s %-22s %-18s %-13s %-20s \n",
					m.getMovieTitle(), m.getMovieLength(), m.getReleaseDate(),
					m.getDirector(), m.getLeadActor(), m.getRevenue(),
					genreName, ratingName);
			
			}
		
		
	}

	private void deleteMovie() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter the movie ID number you would like to delete: \n");
		int movieIdDelete = scanner.nextInt();
		movieDao.deleteMovie(movieIdDelete);
	}

	// creates a new move genre. need to add list of genres when new genre is added
	private void createGenre() throws SQLException {
		System.out.print("Enter new genre: ");
		String genreName = scanner.nextLine();                                                             
		genreDao.createNewGenre(genreName);
	}

	private void updateGenre() throws SQLException {
		displayAllMoviesByGenre();

		System.out.println("Enter the id for the genre you would like to update: \n");
		int genreId = Integer.parseInt(scanner.nextLine());
		System.out.println("Please enter the updated genre: ");
		String updatedGenre = scanner.nextLine();
		genreDao.updateGenre(genreId, updatedGenre);
	}
//this method needs serious overhaul - inner join complexity
	private List<Genre> displayAllMoviesByGenre() throws SQLException {
		List<Genre> moviesByGenres = genreDao.displayAllMovieByGenre();
		List<Movie> moviesList = movieDao.getMovie();
		for(Genre g : moviesByGenres) {
			for(Movie m : moviesList) {
				System.out.println(g.getGenreName() +":"+" id: " + g.getGenreId() +" : " + m.getMovieTitle() + m.getGenres() );
			}
		}
		return moviesByGenres;
	}
private List<Genre> displayAllGenre() throws SQLException {
	List<Genre> moviesByGenre = genreDao.getAllGenre();
	int counter = 1;
	for(Genre m : moviesByGenre) {
		System.out.println(" " + counter + ":"+" id: " + m.getGenreId() +" Name: " + m.getGenreName());
		counter++;
	}
	//System.out.println("Please enter the Genre Id for the list of movies you would like to see: \n");
	//int genreId = Integer.parseInt(scanner.nextLine());
	return moviesByGenre;
	}

	private void deleteGenre() throws SQLException {
		System.out.println("Here is the current list of genres: ");
		displayAllGenres();
		System.out.println("Enter the genre ID number you would like to delete: \n");
		int genreIdDelete = scanner.nextInt();
		boolean isGenreExisting = checkGenreExists(genreIdDelete);
		if (isGenreExisting) {
			boolean isGenreInUse = genreInUse(genreIdDelete);
			if ( !isGenreInUse ) {
				genreDao.deleteGenre(genreIdDelete);
			} else {
				System.out.println("Sorry, that genre is still tied to movies in the database and cannot be deleted.");
			}
		} else {
			System.out.println("Sorry, that genre does not exist.");
		}
	}
	

	private void updateRating() throws SQLException {
		System.out.println("Here are the current movie ratings: ");
		displayAllRatings();
		System.out.print("Enter rating number you want to change: ");
		int ratingId = intScanner.nextInt();
		System.out.println("What would you like the rating changed to?");
		String updatedRating = scanner.nextLine();			
		ratingDao.updateRatingById(ratingId, updatedRating);
		System.out.println("The updated rating list is: ");
		displayAllRatings();
		System.out.println("\n\n");
	}

	private void displayAllMoviesByRating() throws SQLException {
		System.out.println("Enter the rating number below to see a list of movies with that rating: \n");
		displayAllRatings();
		int movieRating = intScanner.nextInt();
		List<Movie> moviesByRating = movieDao.getMovieByRating(movieRating);
		String ratingName = ratingDao.getRatingById(movieRating);
		System.out.println("Here is your list of movies with a rating of '"+ ratingName + "'");
		for ( Movie m : moviesByRating ) {
			System.out.println(m.getMovieTitle() + " : " + m.getMovieLength() + " : " 
					+ m.getReleaseDate() + " : " + m.getDirector() + " : " 
					+ m.getLeadActor() + " : " + m.getRevenue() + " : " 
					+ m.getGenres());
			}
		System.out.println("\n\n");
	}
	
	private void createNewRating() throws SQLException {
		System.out.println("Here are the current ratings: ");
		displayAllRatings();
		System.out.println("Enter the new 'rating' you want to create: ");
		String newRating = scanner.nextLine();
		ratingDao.createNewRating(newRating);
	}

	private void deleteRating() throws SQLException {
		System.out.println("Here are the current ratings: ");
		displayAllRatings();
		System.out.println("Enter the number for the 'rating' you want to delete: ");
		int delete = intScanner.nextInt();
		ratingDao.deleteARating(delete);
		
	} 
	
	private void displayAllGenres() throws SQLException {
		List<Genre> genreOptions = genreDao.getAllGenre();
		for ( Genre genre : genreOptions ) {
			System.out.println(genre.getGenreId() + ": " + genre.getGenreName());
		}
		
	}
	
	private boolean checkGenreExists(int genreIdDelete) throws SQLException {
		List<Genre> genreOptions = genreDao.getAllGenre();
		for ( Genre genre : genreOptions ) {
			if ( genre.getGenreId() == genreIdDelete) {
				return true;
			}
		}
		return false;
	}
	
	private boolean genreInUse(int genreIdDelete) throws SQLException {
		List<Movie> movies = movieDao.getMovie();
		for ( Movie movie : movies ) {
			if ( movie.getGenres() == genreIdDelete) {
				return true;
			}
		}
		return false;
	}
	
	private void displayAllRatings() throws SQLException {
		List<Rating> ratingOptions = ratingDao.getAllRatings();
		for ( Rating rating : ratingOptions ) {
			System.out.println( rating.getRatingId() + ": " + rating.getRatingScale());
		}
	}
}
