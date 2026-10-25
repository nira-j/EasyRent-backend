package com.easyrent.service;

import com.easyrent.dto.*;
import com.easyrent.model.*;
import com.easyrent.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class RentalService {
	private final RentalRepository rentals;
	private final RentalItemRepository items;
	private final UserRepository users;

	public RentalService(RentalRepository r, RentalItemRepository i, UserRepository u) {
		rentals = r;
		items = i;
		users = u;
	}

	public RentalResponse create(CreateRentalRequest r) {
		RentalItem item = items.findById(r.itemId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
		User renter = users.findById(r.renterId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Renter not found"));
		if (!item.isAvailable())
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Item is currently unavailable");
		Rental x = new Rental();
		x.setItem(item);
		x.setRenter(renter);
		x.setStartDate(r.startDate());
		x.setDays(r.days());
		x.setTotalAmount(item.getPricePerDay() * r.days());
		x.setStatus(RentalStatus.REQUESTED);
		x.setMessage(r.message());
		return RentalResponse.from(rentals.save(x));
	}

	public List<RentalResponse> byRenter(Long id) {
		return rentals.findByRenterIdOrderByIdDesc(id).stream().map(RentalResponse::from).toList();
	}
}