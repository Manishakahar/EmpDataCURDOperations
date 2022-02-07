package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.User;


public interface UserService {
	
	public User addUser (User user);
	
	public List<User> getUser();
	
	public User updateUser(int id, String lastNameInput);

	public User getUserById(int id);

	public User deleteUser(int id);

}
