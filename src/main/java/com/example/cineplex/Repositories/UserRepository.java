package com.example.cineplex.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cineplex.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
}
