package com.supermarket.supermarketapi.service.impl;

import com.supermarket.supermarketapi.model.dto.PurchaseSupermarketDto;
import com.supermarket.supermarketapi.model.entity.Item;
import com.supermarket.supermarketapi.model.entity.Purchase;
import com.supermarket.supermarketapi.model.entity.Supermarket;
import com.supermarket.supermarketapi.model.enums.PaymentType;
import com.supermarket.supermarketapi.repository.ItemRepository;
import com.supermarket.supermarketapi.repository.PurchaseRepository;
import com.supermarket.supermarketapi.repository.SupermarketRepository;
import com.supermarket.supermarketapi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    public static final double INITIALIZATION_VARIABLE = 0.0;
    private PurchaseRepository purchaseRepository;
    private SupermarketRepository supermarketRepository;
    private ItemRepository itemRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ItemRepository itemRepository, SupermarketRepository supermarketRepository) {
        this.purchaseRepository = purchaseRepository;
        this.itemRepository = itemRepository;
        this.supermarketRepository = supermarketRepository;
    }

    public Purchase makePurchase(PurchaseSupermarketDto purchaseSupermarketDto) {
        Purchase purchase = new Purchase();
        LocalDateTime timeBegin = LocalDateTime.now();
        Optional<Supermarket> optionalSupermarket = this.supermarketRepository.findById(purchaseSupermarketDto.getSupermarketId());

        List<Item> newItems = new ArrayList<>();
        Double totalPrice = INITIALIZATION_VARIABLE;
        if (optionalSupermarket.isPresent()) {
            List<Item> supermarketItems = new ArrayList<>(optionalSupermarket.get().getItemIds());
            for (String itemId : purchaseSupermarketDto.getItemIds()) {
                Optional<Item> optionalItem = itemRepository.findById(itemId);
                if (optionalItem.isPresent() && supermarketItems.contains(optionalItem.get())) {
                    newItems.add(optionalItem.get());
                    totalPrice += optionalItem.get().getPrice();
                }
            }
        }
        purchase.setSuperMarketId(purchaseSupermarketDto.getSupermarketId());
        purchase.setPaymentType(purchaseSupermarketDto.getPaymentType());
        purchase.setTotalPrice(totalPrice);
        if (Objects.equals(PaymentType.CASH, purchase.getPaymentType())) {
            Double moneyAfterPayment = purchaseSupermarketDto.getCashAmount() - totalPrice;
            purchase.setCashAmount(moneyAfterPayment);
            purchase.setTotalPriceChange(moneyAfterPayment);
            purchase.setTimePurchased(LocalDateTime.now());
        }
        return this.purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getAll() {
        return this.purchaseRepository.findAll();
    }

}
