package com.supermarket.supermarketapi.repository;

import com.supermarket.supermarketapi.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
