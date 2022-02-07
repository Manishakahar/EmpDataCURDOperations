package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userservice;

	public UserController(UserService userservice) {
		super();
		this.userservice = userservice;
	}

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userservice.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/getUser")
	public List<User> getUser() {
		return userservice.getUser();
	}

	@GetMapping("/getUserById")
	public User fetchUserById(@RequestParam(value = "id") int id) {
		return userservice.getUserById(id);
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestParam int id, String lastNameInput) {
		return userservice.updateUser(id, lastNameInput);
	}
	
	@DeleteMapping("/deleteUser/{id}") 
	public User deleteUser(@PathVariable int id){
		return userservice.deleteUser(id);
		
	}
}
