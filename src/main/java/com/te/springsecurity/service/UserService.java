package com.te.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.te.springsecurityentity.User;


@Service
public class UserService {

	public List<User> list=new ArrayList<>();
	
	
	public UserService() {
		list.add(new User("Techno", "tech", "1234"));
		list.add(new User("Elevate", "Elev", "1234"));
		
	}
	
	//getAll user//
	public List<User>getAllUser(){
		return this.list;
		
	}
	
	public User addUser(User user) {
		this.list.add(user);
		return user;
		
	}

	public static Object register(User user) {
		
		return null;
	}
}
