package com.leila.springDemoJG.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leila.springDemoJG.entity.Users;
import com.leila.springDemoJG.exeception.RessouceNotFoundException;
import com.leila.springDemoJG.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	//get all users
	@GetMapping
	public List<Users> getAllUsers(){
		return repo.findAll();
	}
	
	
	//get user by id
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable(value = "id") long userId) {
		return this.repo.findById(userId).orElseThrow(() -> new RessouceNotFoundException("User not found with id " + userId));
		
	}
	
	//create user
	@PostMapping
	public Users createUser(@RequestBody Users user) {
		return this.repo.save(user);
	}
	
	//UpdateUser
	@PutMapping("/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable("id") long id) {
		Users existing = this.repo.findById(id).orElseThrow(() -> new RessouceNotFoundException("User not found with id " + id));
		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setEmail(user.getEmail());
		return this.repo.save(existing);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable("id") long userId){
		Users existing = this.repo.findById(userId).orElseThrow(() -> new RessouceNotFoundException("User not found with id " + userId));
		 repo.delete(existing);
		 return ResponseEntity.ok().build();
		
	}
	
	

}

