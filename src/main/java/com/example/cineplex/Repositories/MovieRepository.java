package com.example.cineplex.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cineplex.Entities.Movie;
import com.example.cineplex.Entities.SeatBooking;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	
	@Query(value="SELECT sb.seatId FROM SeatBooking sb WHERE sb.movieShowtimeId = :movieShowtimeId")
	List<Long> findSeatBookingsForShowtimes (@Param("movieShowtimeId") Long movieShowtimeId);

}
