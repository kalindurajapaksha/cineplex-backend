package com.example.cineplex.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cineplex.JwtTokenUtil;
import com.example.cineplex.DTOs.AuthRequest;
import com.example.cineplex.Entities.User;
import com.example.cineplex.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value="/auth/signup", method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		String password = user.getPassword();
		userService.createUser(user);
		return userService.login(user.getEmail(), password);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> readUsers() {
	    return userService.getUsers();
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable(value="userId") Long id, @RequestBody User userDetails) {
	    return userService.updateUser(id, userDetails);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value="userId") Long id) {
	     return userService.deleteUser(id);
	}
	
    @RequestMapping(value="/auth/login", method=RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
    	return userService.login(request.getEmail(), request.getPassword());
    }
	
}
