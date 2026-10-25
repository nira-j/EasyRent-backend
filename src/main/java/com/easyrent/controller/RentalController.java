package com.easyrent.controller;

import com.easyrent.dto.*;
import com.easyrent.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
	private final RentalService service;

	public RentalController(RentalService s) {
		service = s;
	}

	@PostMapping
	public RentalResponse create(@Valid @RequestBody CreateRentalRequest r) {
		return service.create(r);
	}

	@GetMapping("/renter/{renterId}")
	public List<RentalResponse> byRenter(@PathVariable Long renterId) {
		return service.byRenter(renterId);
	}
}