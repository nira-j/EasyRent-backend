package com.easyrent.service;

import com.easyrent.dto.*;
import com.easyrent.model.*;
import com.easyrent.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class ItemService {
	private final RentalItemRepository items;
	private final CategoryRepository categories;
	private final UserRepository users;

	public ItemService(RentalItemRepository i, CategoryRepository c, UserRepository u) {
		items = i;
		categories = c;
		users = u;
	}

	public List<ItemResponse> list(String category, String q) {
		List<RentalItem> a = (category == null || category.isBlank()) ? items.findAll()
				: items.findByCategorySlug(category);
		if (q == null || q.isBlank())
			return a.stream().map(ItemResponse::from).toList();
		String t = q.toLowerCase();
		return a.stream()
				.filter(x -> (x.getName() + " " + Objects.toString(x.getDescription(), "") + " "
						+ Objects.toString(x.getLocation(), "")).toLowerCase().contains(t))
				.map(ItemResponse::from).toList();
	}

	public ItemResponse get(Long id) {
		return ItemResponse.from(items.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found")));
	}

	public ItemResponse create(CreateItemRequest r) {
		Category c = categories.findById(r.categoryId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
		User o = users.findById(r.ownerId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
		RentalItem x = new RentalItem();
		x.setName(r.name());
		x.setCategory(c);
		x.setPricePerDay(r.pricePerDay());
		x.setLocation(r.location());
		x.setDescription(r.description());
		x.setImageUrl(r.imageUrl());
		x.setOwner(o);
		return ItemResponse.from(items.save(x));
	}
}