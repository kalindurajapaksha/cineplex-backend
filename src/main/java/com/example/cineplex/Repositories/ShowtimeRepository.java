package com.example.cineplex.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cineplex.Entities.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

}
