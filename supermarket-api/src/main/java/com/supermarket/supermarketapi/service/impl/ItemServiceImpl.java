package com.supermarket.supermarketapi.service.impl;

import com.supermarket.supermarketapi.model.dto.ItemDto;
import com.supermarket.supermarketapi.model.entity.Item;
import com.supermarket.supermarketapi.repository.ItemRepository;
import com.supermarket.supermarketapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setItemType(itemDto.getItemType());
        item.setPrice(itemDto.getPrice());
        return this.itemRepository.save(item);
    }
}
