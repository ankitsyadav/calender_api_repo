package com.calender.api.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calender.api.entities.User;
import com.calender.api.services.UserService;

@RestController
@RequestMapping("/users/cal")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService us;

//	create 
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User u1 = this.us.createUser(user);
		return new ResponseEntity<>(u1, HttpStatus.CREATED);
	}

//	update
	@PutMapping("/{id}")
	public ResponseEntity<User> UpdateUser(@Valid @RequestBody User user, @PathVariable int id) {
		User u1 = this.us.updateUser(user, id);
		return new ResponseEntity<>(u1, HttpStatus.OK);

	}

//	delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable int id) {
		this.us.deleteUser(id);
		Map<String, String> message = Map.of("message", "product deleted successfull");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

//	get single user
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) {
		User u1 = this.us.getUserById(id);
		return new ResponseEntity<>(u1, HttpStatus.OK);

	}

//	get all 

	@GetMapping
	public ResponseEntity<List<User>> getUser() {
		List<User> list = this.us.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

//	check lisence

	@GetMapping("/license/{email}/{sheetId}")
	public ResponseEntity<Boolean> checkLicense(@PathVariable("email") String email,
			@PathVariable("sheetId") String sheetId) {
		Boolean res = this.us.checkLicense(email, sheetId);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/checkStatus")
	public ResponseEntity<List<User>> checkStatus() {
		List<User> list = this.us.checkStatus();
		return new ResponseEntity<>(list, HttpStatus.OK);

	}

}
