package com.example.cineplex.DTOs;

import java.util.List;

public class ShowtimeDTO {
	
	private Long id;
	
	private Long movieShowtimeid;
	
	private String label;
	
	private List<Long> unavailableSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Long> getUnavailableSeats() {
		return unavailableSeats;
	}

	public void setUnavailableSeats(List<Long> unavailableSeats) {
		this.unavailableSeats = unavailableSeats;
	}

	public Long getMovieShowtimeid() {
		return movieShowtimeid;
	}

	public void setMovieShowtimeid(Long movieShowtimeid) {
		this.movieShowtimeid = movieShowtimeid;
	}	

}
