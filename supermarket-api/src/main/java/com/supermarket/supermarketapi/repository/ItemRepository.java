package com.supermarket.supermarketapi.repository;

import com.supermarket.supermarketapi.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
