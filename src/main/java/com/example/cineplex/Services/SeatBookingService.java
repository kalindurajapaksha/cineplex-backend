package com.example.cineplex.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cineplex.DTOs.SeatBookingDTO;
import com.example.cineplex.Entities.SeatBooking;
import com.example.cineplex.Repositories.SeatBookingRepository;

@Service
public class SeatBookingService {
	
	@Autowired
	SeatBookingRepository seatBookingRepository;
	
	public ResponseEntity<?> createSeatBooking(SeatBookingDTO seatBookingDTO) {
		try {
			for(Long seatId: seatBookingDTO.getSeatIds()) {
				SeatBooking seatBooking = new SeatBooking();
				seatBooking.setMovieShowtimeId(seatBookingDTO.getMovieShowtimeId());
				seatBooking.setUserId(seatBookingDTO.getUserId());
				seatBooking.setSeatId(seatId);
				seatBookingRepository.save(seatBooking);
			}
			return ResponseEntity.ok().body(null);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<?> getAvailableSeats(Long movieShowtimeId) {
		try {
			return ResponseEntity.ok().body(seatBookingRepository.getAvailableSeats(movieShowtimeId));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<?> deleteSeatBooking(Long seatBookingId) {
		try {
			seatBookingRepository.deleteById(seatBookingId);
			return ResponseEntity.ok().body(seatBookingId);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	public ResponseEntity<?> getBookedSeats (Long userId){
		try {
			return ResponseEntity.ok().body(seatBookingRepository.getBookedSeats(userId));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
