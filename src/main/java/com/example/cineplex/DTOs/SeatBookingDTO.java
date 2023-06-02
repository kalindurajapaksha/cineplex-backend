package com.example.cineplex.DTOs;

import java.util.List;

public class SeatBookingDTO {
	
	private Long id;
	
	private Long movieShowtimeId;
	
	private Long userId;
	
	private List<Long> seatIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieShowtimeId() {
		return movieShowtimeId;
	}

	public void setMovieShowtimeId(Long movieShowtimeId) {
		this.movieShowtimeId = movieShowtimeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getSeatIds() {
		return seatIds;
	}

	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}
	
	

}
