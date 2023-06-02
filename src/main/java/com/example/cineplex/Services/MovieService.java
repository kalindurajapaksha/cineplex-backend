package com.example.cineplex.Services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cineplex.DTOs.CreateMovieDTO;
import com.example.cineplex.DTOs.MovieDTO;
import com.example.cineplex.DTOs.ShowtimeDTO;
import com.example.cineplex.Entities.Movie;
import com.example.cineplex.Entities.MovieShowtime;
import com.example.cineplex.Entities.Showtime;
import com.example.cineplex.Repositories.MovieRepository;
import com.example.cineplex.Repositories.MovieShowtimeRepository;
import com.example.cineplex.Repositories.ShowtimeRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieShowtimeRepository movieShowtimeRepository;
	
	@Autowired
	ShowtimeRepository showtimeRepository;
	
	public void createBulkMovies(Movie [] movies) {
		for (Movie element : movies) {
			 movieRepository.save(element);
		}
		
	}
	
	public Movie createMovie(CreateMovieDTO movieDTO) {
		Movie movie = new Movie();
		movie.setName(movieDTO.getName());
		movie.setDescription(movieDTO.getDescription());
		movie.setAvailableSeats(movieDTO.getAvailableSeats());
		movie.setImage(movieDTO.getImage());
		
	    Movie createdMovie = movieRepository.save(movie);
	    
	    for (Long showtimeId: movieDTO.getShowtimes()) {
	    	MovieShowtime movieShowtime = new MovieShowtime();
	    	movieShowtime.setMovieId(createdMovie.getId());
	    	movieShowtime.setShowtimeId(showtimeId);
	    	
	    	movieShowtimeRepository.save(movieShowtime);
	    }
	    
	    return createdMovie;
	    
	}

	public List<Movie> getMovies() {
	    return movieRepository.findAll();
	}
	
	public MovieDTO getMovie(Long movieId) {
		
		MovieDTO movieDTO = new MovieDTO();
		
	    Movie movie = movieRepository.findById(movieId).get();
	    movieDTO.setId(movie.getId());
	    movieDTO.setName(movie.getName());
	    movieDTO.setDescription(movie.getDescription());
	    movieDTO.setImage(movie.getImage());
	    movieDTO.setAvailableSeats(movie.getAvailableSeats());
	    
	    List<MovieShowtime> movieShowtimes = movieShowtimeRepository.findShowtimesByMovie(movieId);
	    
	    List<ShowtimeDTO> showtimes = new ArrayList<ShowtimeDTO>();
	    
	    for (MovieShowtime movieShowtime: movieShowtimes ) {
	    	Showtime showtime = showtimeRepository.findById(movieShowtime.getShowtimeId()).get();
	    	ShowtimeDTO showtimeDTO = new ShowtimeDTO();
	    	showtimeDTO.setMovieShowtimeid(movieShowtime.getId());
	    	showtimeDTO.setId(showtime.getId());
	    	showtimeDTO.setLabel(showtime.getLabel()); 
	    	showtimeDTO.setUnavailableSeats(movieRepository.findSeatBookingsForShowtimes(movieShowtime.getId()));
	    	showtimes.add(showtimeDTO);
	    }
	    
	    movieDTO.setShowtimes(showtimes);
	    
	    return movieDTO;
	    
	    
	}

	public void deleteMovie(Long movieId) {
		movieRepository.deleteById(movieId);
	}
	
	public Movie updateMovie(Long movieId, Movie movieDetails) {
	        Movie movie = movieRepository.findById(movieId).get();
	        movie.setName(movieDetails.getName());
	        movie.setDescription(movieDetails.getDescription());
	        movie.setImage(movieDetails.getImage());
	        
	        return movieRepository.save(movie);                                
	}

}
