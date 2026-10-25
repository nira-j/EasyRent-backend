package com.easyrent.controller;

import com.easyrent.dto.*;
import com.easyrent.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	private final ItemService service;

	public ItemController(ItemService s) {
		service = s;
	}

	@GetMapping
	public List<ItemResponse> list(@RequestParam(required = false) String category,
			@RequestParam(required = false, name = "q") String q) {
		return service.list(category, q);
	}

	@GetMapping("/{id}")
	public ItemResponse get(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public ItemResponse create(@Valid @RequestBody CreateItemRequest r) {
		return service.create(r);
	}
}