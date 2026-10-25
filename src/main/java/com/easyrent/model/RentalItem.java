package com.easyrent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rental_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id")
	private Category category;
	@Column(nullable = false)
	private double pricePerDay;
	@Column(nullable = false)
	private boolean available = true;
	private String location;
	@Column(length = 4000)
	private String description;
	private String imageUrl;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "owner_id")
	private User owner;
	private double rating = 0.0;
	private int reviewCount = 0;
}