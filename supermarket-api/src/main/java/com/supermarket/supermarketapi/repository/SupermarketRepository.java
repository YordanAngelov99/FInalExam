package com.supermarket.supermarketapi.repository;

import com.supermarket.supermarketapi.model.entity.Supermarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermarketRepository extends JpaRepository<Supermarket, String> {
}
