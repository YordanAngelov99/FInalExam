package com.supermarket.supermarketapi.controller;

import com.supermarket.supermarketapi.model.dto.ItemDto;
import com.supermarket.supermarketapi.model.entity.Item;
import com.supermarket.supermarketapi.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemDto) {
        Item newItem = this.itemService.createItem(itemDto);
        return new ResponseEntity<>(modelMapper.map(newItem, ItemDto.class), HttpStatus.CREATED);
    }

}
