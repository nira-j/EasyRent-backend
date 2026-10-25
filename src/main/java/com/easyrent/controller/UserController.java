package com.easyrent.controller;

import com.easyrent.model.User;
import com.easyrent.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserRepository repo;

	public UserController(UserRepository r) {
		repo = r;
	}

	@GetMapping
	public List<User> all() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable Long id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
}