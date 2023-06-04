package com.example.cineplex.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cineplex.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	@Query(value="SELECT sb.seatId FROM SeatBooking sb WHERE sb.movieShowtimeId = :movieShowtimeId")
	List<Long> findSeatBookingsForShowtimes (@Param("movieShowtimeId") Long movieShowtimeId);

	@Query(value="SELECT ms.id FROM (SELECT * FROM movie_showtime WHERE movie_id = :movieId ) ms JOIN seat_booking sb ON sb.movie_showtime_id = ms.id;",nativeQuery = true)
	List<Long> findSeatBookingsCountForMovie (@Param("movieId") Long movieId);

}
