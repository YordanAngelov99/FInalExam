package com.supermarket.supermarketapi.controller;

import com.supermarket.supermarketapi.model.dto.SupermarketDto;
import com.supermarket.supermarketapi.model.dto.SupermarketWithItemsDto;
import com.supermarket.supermarketapi.model.entity.Supermarket;
import com.supermarket.supermarketapi.service.SupermarketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/supermarket")
public class SupermarketController {
    private ModelMapper modelMapper = new ModelMapper();
    private SupermarketService supermarketService;

    @Autowired
    public SupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping("/create")
    public ResponseEntity<SupermarketDto> createSupermarket(@Valid @RequestBody SupermarketDto supermarketDto) {
        Supermarket newSupermarket = this.supermarketService.createSupermarket(supermarketDto);
        return new ResponseEntity<>(modelMapper.map(newSupermarket, SupermarketDto.class), HttpStatus.CREATED);
    }

    @PostMapping("/addItems")
    public ResponseEntity<Supermarket> addItemsToSupermarket(@Valid @RequestBody SupermarketWithItemsDto supermarketWithItemsDto) {
        Supermarket supermarket = this.supermarketService.addItemsToSupermarket(supermarketWithItemsDto.getId(), supermarketWithItemsDto.getItemIds());
        return new ResponseEntity<>(modelMapper.map(supermarket, Supermarket.class), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupermarketDto> getSupermarketById(@PathVariable(value = "id", required = true) String supermarketId) {
        Supermarket supermarket = this.supermarketService.getSupermarketByid(supermarketId);
        return new ResponseEntity<>(modelMapper.map(supermarket, SupermarketDto.class), HttpStatus.OK);
    }

}
