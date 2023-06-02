package com.example.cineplex.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cineplex.DTOs.BookedSeatsDTO;
import com.example.cineplex.DTOs.SeatBookingDTO;
import com.example.cineplex.DTOs.SeatDTO;
import com.example.cineplex.Entities.SeatBooking;
import com.example.cineplex.Repositories.SeatBookingRepository;

@Service
public class SeatBookingService {
	
	@Autowired
	SeatBookingRepository seatBookingRepository;
	
	public void createSeatBooking(SeatBookingDTO seatBookingDTO) {
		
		for(Long seatId: seatBookingDTO.getSeatIds()) {
			SeatBooking seatBooking = new SeatBooking();
			seatBooking.setMovieShowtimeId(seatBookingDTO.getMovieShowtimeId());
			seatBooking.setUserId(seatBookingDTO.getUserId());
			System.out.println(seatId);
			seatBooking.setSeatId(seatId);
			seatBookingRepository.save(seatBooking);
		}
	}
	
	public List<SeatDTO> getAvailableSeats(Long movieShowtimeId) {
		return seatBookingRepository.getAvailableSeats(movieShowtimeId);
	}
	
	public void deleteSeatBooking(Long seatBookingId) {
		seatBookingRepository.deleteById(seatBookingId);
	}
	
	public List<BookedSeatsDTO> getBookedSeats (Long userId){
		return seatBookingRepository.getBookedSeats(userId);
	}

}
