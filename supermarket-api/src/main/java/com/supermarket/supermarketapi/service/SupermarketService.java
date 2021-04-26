package com.supermarket.supermarketapi.service;

import com.supermarket.supermarketapi.model.dto.SupermarketDto;
import com.supermarket.supermarketapi.model.entity.Supermarket;

import java.util.List;

public interface SupermarketService {
    Supermarket createSupermarket(SupermarketDto supermarketDto);

    Supermarket addItemsToSupermarket(String supermarketId, List<String> itemIds);

    Supermarket getSupermarketByid(String supermarketId);
}
