package com.im.crud.api.spring.mysql.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.im.crud.api.spring.mysql.entity.User;
import com.im.crud.api.spring.mysql.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	// Insertion d'un utilisateur
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	// Recuperer un seul utilisateur
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int userId) {
		return userService.getUserById(userId);
	}

	// Recuperer tous les utilisateurs
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Mettre à jour l'utlisateur
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		try {
			userService.updateUserById(user);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	// Supprimer l'enregistrement utilisateur
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		try {
			userService.deleteUserById(userId);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

}
