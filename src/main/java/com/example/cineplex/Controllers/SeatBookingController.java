package com.example.cineplex.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cineplex.DTOs.BookedSeatsDTO;
import com.example.cineplex.DTOs.SeatBookingDTO;
import com.example.cineplex.DTOs.SeatDTO;
import com.example.cineplex.Entities.SeatBooking;
import com.example.cineplex.Services.SeatBookingService;

@RestController
@RequestMapping("/seatBooking")
public class SeatBookingController {

	@Autowired
	SeatBookingService seatBookingService;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public void createSeatBooking(@RequestBody SeatBookingDTO seatBookingDTO) {
	     seatBookingService.createSeatBooking(seatBookingDTO);
	}
	
	@RequestMapping(value="/getAvailableSeats/{movieShowtimeId}", method=RequestMethod.GET)
	public List<SeatDTO> getAvailableSeats(@PathVariable(value="movieShowtimeId") Long movieShowtimeId) {
	    return seatBookingService.getAvailableSeats(movieShowtimeId);
	}
	
	@RequestMapping(value="/{seatBookingId}", method=RequestMethod.DELETE)
	public void deleteSeatBooking(@PathVariable(value="seatBookingId") Long seatBookingId) {
		seatBookingService.deleteSeatBooking(seatBookingId);
	}
	
	@RequestMapping(value="/getBookedSeats/{userId}", method=RequestMethod.GET)
	public List<BookedSeatsDTO> getBookedSeats(@PathVariable(value="userId") Long userId) {
	    return seatBookingService.getBookedSeats(userId);
	}
}
