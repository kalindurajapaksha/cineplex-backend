package com.example.cineplex.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cineplex.Repositories.ShowtimeRepository;

@Service
public class ShowtimeService {
	
	@Autowired
	ShowtimeRepository showtimeRepository;

}
