package com.devsuperior.hruser.resourcers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

// Endpoints da minha aplicação
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

	@GetMapping(value = "/search")

	public ResponseEntity<User> findByEmail(@RequestParam String email) {

		User obj = repository.findByEmail(email);

		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(obj);
	}
}
