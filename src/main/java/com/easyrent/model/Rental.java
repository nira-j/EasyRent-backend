package com.easyrent.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_id")
	private RentalItem item;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "renter_id")
	private User renter;
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false)
	private int days;
	@Column(nullable = false)
	private double totalAmount;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RentalStatus status = RentalStatus.REQUESTED;
	@Column(length = 1000)
	private String message;
}