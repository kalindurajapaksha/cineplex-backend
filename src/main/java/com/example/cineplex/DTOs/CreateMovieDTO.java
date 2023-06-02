package com.example.cineplex.DTOs;

public class CreateMovieDTO {
	
	private Long id;
	
	private String name;
	
	private String image;
	
	private String description;
	
	private int availableSeats;
	
	private Long[] showtimes;

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

	public Long[] getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Long[] showtimes) {
		this.showtimes = showtimes;
	}
	
	

}
