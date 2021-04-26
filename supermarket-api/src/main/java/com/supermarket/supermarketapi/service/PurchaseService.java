package com.supermarket.supermarketapi.service;

import com.supermarket.supermarketapi.model.dto.PurchaseSupermarketDto;
import com.supermarket.supermarketapi.model.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase makePurchase(PurchaseSupermarketDto purchaseSupermarketDto);

    List<Purchase> getAll();
}
