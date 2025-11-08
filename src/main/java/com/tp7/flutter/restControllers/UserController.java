package com.tp7.flutter.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tp7.flutter.entities.User;
import com.tp7.flutter.repos.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	 
	@PostMapping("/register")
	public User Register(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	 @PostMapping("/login")
	 public User Login(@RequestBody User user) {
		 User oldUSer = userRepository.findByEmailAndPassword(user.getEmail(),
				 user.getPassword());
		 return oldUSer;
	 }
}

