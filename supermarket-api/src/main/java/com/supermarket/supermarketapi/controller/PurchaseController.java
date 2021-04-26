package com.supermarket.supermarketapi.controller;

import com.supermarket.supermarketapi.model.dto.PurchaseDto;
import com.supermarket.supermarketapi.model.dto.PurchaseSupermarketDto;
import com.supermarket.supermarketapi.model.entity.Purchase;
import com.supermarket.supermarketapi.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private ModelMapper modelMapper = new ModelMapper();
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseDto> buyItemsFromSupermarket(@Valid @RequestBody PurchaseSupermarketDto purchaseSupermarketDto) {
        Purchase newPurchase = this.purchaseService.makePurchase(purchaseSupermarketDto);
        return new ResponseEntity<>(modelMapper.map(newPurchase, PurchaseDto.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getPurchases() {
        return new ResponseEntity(purchaseService.getAll(), HttpStatus.OK);
    }

}
