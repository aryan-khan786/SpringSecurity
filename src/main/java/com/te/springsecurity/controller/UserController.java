package com.te.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springsecurity.service.UserService;
import com.te.springsecurityentity.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/User")
	public List<User> getAllUser() {
		return this.userService.getAllUser();

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		if (UserService.register(user) != null) {
			return new ResponseEntity<String>("Data entrered", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return this.userService.addUser(user);

	}
		@GetMapping("/delete")
		public String delete() {
			return "This is the delete request";
		}
		

	}
	
//	@GetMapping
//	public User getUser(String username) {
//		return this.userService.getUser(username);
//	}
	
	
