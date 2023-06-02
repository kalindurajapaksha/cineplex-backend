package com.example.cineplex.DTOs;

import java.util.List;


public class MovieDTO {
	
	private Long id;
	
	private String name;
	
	private String image;
	
	private String description;
	
	private int availableSeats;
	
	private List<ShowtimeDTO> showtimes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public List<ShowtimeDTO> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<ShowtimeDTO> showtimes) {
		this.showtimes = showtimes;
	}
	

}
