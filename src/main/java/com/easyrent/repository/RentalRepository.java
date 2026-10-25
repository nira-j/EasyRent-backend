package com.easyrent.repository;

import com.easyrent.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface RentalRepository extends JpaRepository<Rental, Long> {
	List<Rental> findByRenterIdOrderByIdDesc(Long renterId);
}