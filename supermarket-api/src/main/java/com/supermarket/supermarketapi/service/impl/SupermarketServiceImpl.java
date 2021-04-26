package com.supermarket.supermarketapi.service.impl;

import com.supermarket.supermarketapi.exception.SupermarketNotFoundException;
import com.supermarket.supermarketapi.model.dto.SupermarketDto;
import com.supermarket.supermarketapi.model.entity.Item;
import com.supermarket.supermarketapi.model.entity.Supermarket;
import com.supermarket.supermarketapi.repository.ItemRepository;
import com.supermarket.supermarketapi.repository.SupermarketRepository;
import com.supermarket.supermarketapi.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    private SupermarketRepository supermarketRepository;
    private ItemRepository itemRepository;

    @Autowired
    public SupermarketServiceImpl(SupermarketRepository supermarketRepository, ItemRepository itemRepository) {
        this.supermarketRepository = supermarketRepository;
        this.itemRepository = itemRepository;
    }

    public Supermarket createSupermarket(SupermarketDto supermarketDto) {
        Supermarket supermarket = new Supermarket();
        supermarket.setName(supermarketDto.getName());
        supermarket.setAddress(supermarketDto.getAddress());
        supermarket.setPhoneNumber(supermarketDto.getPhoneNumber());
        supermarket.setWorkHours(supermarketDto.getWorkHours());
        supermarket.setItemIds(null);
        return this.supermarketRepository.save(supermarket);
    }

    public Supermarket addItemsToSupermarket(String supermarketId, List<String> itemIds) {
        Optional<Supermarket> optionalSupermarket = this.supermarketRepository.findById(supermarketId);
        if (optionalSupermarket.isEmpty()) {
            throw new SupermarketNotFoundException("There is no supermarket with id " + supermarketId);
        }
        Supermarket newSupermarket = optionalSupermarket.get();
        List<Item> newListOfItems = new ArrayList<>();
        for (String itemId : itemIds) {
            Optional<Item> item = this.itemRepository.findById(itemId);
            if (item.isPresent()) {
                newListOfItems.add(item.get());
            }
        }
        newSupermarket.setItemIds(newListOfItems);
        return this.supermarketRepository.save(newSupermarket);
    }

    public Supermarket getSupermarketByid(String supermarketId) {
        return this.supermarketRepository.findById(supermarketId).get();
    }


}
