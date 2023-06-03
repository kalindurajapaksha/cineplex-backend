package com.example.cineplex.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cineplex.DTOs.CreateMovieDTO;
import com.example.cineplex.Entities.Movie;
import com.example.cineplex.Services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<?> createMovie(@RequestBody CreateMovieDTO movieDTO) {
	    return movieService.createMovie(movieDTO);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> createBulkMovies(@RequestBody Movie[] movies) {
	     return movieService.createBulkMovies(movies);
	}
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.GET)
	public ResponseEntity<?> getMovie(@PathVariable(value="movieId") Long id) {
		return movieService.getMovie(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> readMovies() {
	    return movieService.getMovies();
	}
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateMovie(@PathVariable(value="movieId") Long id, @RequestBody Movie movieDetails) {
	    return movieService.updateMovie(id, movieDetails);
	}
	
	@RequestMapping(value="/{movieId}", method=RequestMethod.DELETE)
	public void deleteMovie(@PathVariable(value="movieId") Long id) {
		movieService.deleteMovie(id);
	}
}
