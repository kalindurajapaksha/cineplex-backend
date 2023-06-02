package com.example.cineplex.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cineplex.DTOs.BookedSeatsDTO;
import com.example.cineplex.DTOs.SeatDTO;
import com.example.cineplex.Entities.SeatBooking;

public interface SeatBookingRepository extends JpaRepository<SeatBooking,Long> {
	
	@Query(value="select a.id as seatId, a.number as seatNumber, IF(b.seat_id,1,0) as isBooked \n"
			+ " from seat a left join \n"
			+ " (select * from seat_booking where movie_showtime_id = :movieShowtimeId) b on a.id = b.seat_id", nativeQuery = true)
	List<SeatDTO> getAvailableSeats (@Param("movieShowtimeId") Long movieShowtimeId);
	
	@Query(value="select a.id as seatBookingId, c.name as movieName, c.image as movieImage, d.label as showTime \n"
			+ "from seat_booking a \n"
			+ "left join movie_showtime b on a.movie_showtime_id = b.id\n"
			+ "left join movie c on b.movie_id = c.id\n"
			+ "left join showtime d on b.showtime_id = d.id\n"
			+ "where a.user_id = :userId", nativeQuery = true)
	List<BookedSeatsDTO> getBookedSeats (@Param("userId") Long userId);
	
	

}