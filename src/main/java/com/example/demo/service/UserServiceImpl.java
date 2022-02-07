package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	private User user; 
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getUser() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(int id, String lastNameInput) {
		user=getUserById(id);
		user.setLastName(lastNameInput);
		return userRepo.save(user);
	}

	@Override
	public User getUserById(int id) {
		return userRepo.findById(id).orElseThrow();
	}

	@Override
	public User deleteUser(int id) {
		user=getUserById(id);
		userRepo.delete(user);
		return user;
	}
}
