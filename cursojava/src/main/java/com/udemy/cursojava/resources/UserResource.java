package com.udemy.cursojava.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursojava.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	

	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User(1L, "João", "joao32@gmail.com", "22-74748554", "5417");
		return ResponseEntity.ok().body(u);
	}

}
