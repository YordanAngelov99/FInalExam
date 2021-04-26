package com.supermarket.supermarketapi.service;

import com.supermarket.supermarketapi.model.dto.ItemDto;
import com.supermarket.supermarketapi.model.entity.Item;

public interface ItemService {
    Item createItem(ItemDto itemDto);
}
