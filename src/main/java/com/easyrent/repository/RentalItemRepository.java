package com.easyrent.repository;

import com.easyrent.model.RentalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface RentalItemRepository extends JpaRepository<RentalItem, Long> {
	List<RentalItem> findByCategorySlug(String slug);
}