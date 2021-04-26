package com.supermarket.supermarketapi.model.dto;

import com.supermarket.supermarketapi.model.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    @NotBlank(message = "Item name cannot be null or blank!")
    @Size(max = 64)
    private String name;

    @NotNull(message = "Item price cannot be null!")
    private Double price;

    @NotNull(message = "Item type cannot be null!")
    private ItemType itemType;
}
