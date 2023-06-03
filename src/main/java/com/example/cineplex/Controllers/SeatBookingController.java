package com.example.cineplex.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cineplex.DTOs.SeatBookingDTO;
import com.example.cineplex.Services.SeatBookingService;

@RestController
@RequestMapping("/seatBooking")
public class SeatBookingController {

	@Autowired
	SeatBookingService seatBookingService;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<?> createSeatBooking(@RequestBody SeatBookingDTO seatBookingDTO) {
	     return seatBookingService.createSeatBooking(seatBookingDTO);
	}
	
	@RequestMapping(value="/getAvailableSeats/{movieShowtimeId}", method=RequestMethod.GET)
	public ResponseEntity<?> getAvailableSeats(@PathVariable(value="movieShowtimeId") Long movieShowtimeId) {
	    return seatBookingService.getAvailableSeats(movieShowtimeId);
	}
	
	@RequestMapping(value="/{seatBookingId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteSeatBooking(@PathVariable(value="seatBookingId") Long seatBookingId) {
		return seatBookingService.deleteSeatBooking(seatBookingId);
	}
	
	@RequestMapping(value="/getBookedSeats/{userId}", method=RequestMethod.GET)
	public ResponseEntity<?> getBookedSeats(@PathVariable(value="userId") Long userId) {
	    return seatBookingService.getBookedSeats(userId);
	}
}
