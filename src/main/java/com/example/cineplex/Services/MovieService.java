package com.example.cineplex.Services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> createBulkMovies(Movie[] movies) {
        try {
            for (Movie element : movies) {
                movieRepository.save(element);
            }
            return ResponseEntity.ok().body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> createMovie(CreateMovieDTO movieDTO) {
        try {
            Movie movie = new Movie();
            movie.setName(movieDTO.getName());
            movie.setDescription(movieDTO.getDescription());
            movie.setAvailableSeats(movieDTO.getAvailableSeats());
            movie.setImage(movieDTO.getImage());

            Movie createdMovie = movieRepository.save(movie);

            for (Long showtimeId : movieDTO.getShowtimes()) {
                MovieShowtime movieShowtime = new MovieShowtime();
                movieShowtime.setMovieId(createdMovie.getId());
                movieShowtime.setShowtimeId(showtimeId);

                movieShowtimeRepository.save(movieShowtime);
            }

            return ResponseEntity.ok().body(createdMovie);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> getMovies() {
        try {
            return ResponseEntity.ok().body(movieRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> getMovie(Long movieId) {
        try {
            MovieDTO movieDTO = new MovieDTO();

            Movie movie = movieRepository.findById(movieId).get();
            movieDTO.setId(movie.getId());
            movieDTO.setName(movie.getName());
            movieDTO.setDescription(movie.getDescription());
            movieDTO.setImage(movie.getImage());
            movieDTO.setAvailableSeats(movie.getAvailableSeats());

            List<MovieShowtime> movieShowtimes = movieShowtimeRepository.findShowtimesByMovie(movieId);

            List<ShowtimeDTO> showtimes = new ArrayList<ShowtimeDTO>();

            for (MovieShowtime movieShowtime : movieShowtimes) {
                Showtime showtime = showtimeRepository.findById(movieShowtime.getShowtimeId()).get();
                ShowtimeDTO showtimeDTO = new ShowtimeDTO();
                showtimeDTO.setMovieShowtimeid(movieShowtime.getId());
                showtimeDTO.setId(showtime.getId());
                showtimeDTO.setLabel(showtime.getLabel());
                showtimeDTO.setUnavailableSeats(movieRepository.findSeatBookingsForShowtimes(movieShowtime.getId()));
                showtimes.add(showtimeDTO);
            }

            movieDTO.setShowtimes(showtimes);

            return ResponseEntity.ok().body(movieDTO);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> deleteMovie(Long movieId) {
        try {
        	int numberOfBookings = movieRepository.findSeatBookingsCountForMovie(movieId).size();
        	if (numberOfBookings == 0) {
        		movieShowtimeRepository.deleteByMovieId(movieId);
        	}
            movieRepository.deleteById(movieId);
            return ResponseEntity.ok().body(movieId);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?> updateMovie(Long movieId, Movie movieDetails) {
        try {
            Movie movie = movieRepository.findById(movieId).get();
            movie.setName(movieDetails.getName());
            movie.setDescription(movieDetails.getDescription());
            movie.setImage(movieDetails.getImage());

            return ResponseEntity.ok().body(movieRepository.save(movie));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
