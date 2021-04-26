package com.supermarket.supermarketapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketWithItemsDto {

    @NotBlank
    private String id;

    @NotEmpty
    private List<String> itemIds;
}
