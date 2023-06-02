package com.example.cineplex.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SeatBooking {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long movieShowtimeId;
	
	private Long userId;
	
	private Long seatId;
	
	public SeatBooking() {}

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

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	
	
	
	

}
