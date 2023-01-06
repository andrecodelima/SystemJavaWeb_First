package com.udemy.cursojava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.cursojava.entities.User;
import com.udemy.cursojava.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	

	@Autowired // Declaração de dependência para o service
	private UserService service;
	
	@GetMapping
//	public ResponseEntity<User> findAll(){
	public ResponseEntity<List<User>> findAll(){ // mudança do tipo da lista para lista de usuario

		List<User> list = service.findAll();
		
//		User u = new User(1L, "João", "joao32@gmail.com", "22-74748554", "5417");
//		return ResponseEntity.ok().body(u);
		
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}") //Indica que a requisição aceita um id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
