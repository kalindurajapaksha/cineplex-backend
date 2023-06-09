package com.example.cineplex.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cineplex.Entities.MovieShowtime;

import jakarta.transaction.Transactional;



public interface MovieShowtimeRepository extends JpaRepository<MovieShowtime, Long> {

	@Query(value="SELECT * FROM movie_showtime WHERE movie_id = :movieId", nativeQuery = true)
	List<MovieShowtime> findShowtimesByMovie (@Param("movieId") Long movieId);
	
//	@Query(value="DELETE FROM movie_showtime WHERE movie_id = :movieId", nativeQuery = true)
	@Transactional
	long deleteByMovieId(Long movieId);

}
