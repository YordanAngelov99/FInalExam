package com.supermarket.supermarketapi.model.dto;

import com.supermarket.supermarketapi.model.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketDto {

    @NotBlank
    @Size(max = 64)
    private String name;

    @NotBlank
    @Size(max = 128)
    @Pattern(regexp = ".+,.+,.+")
    private String address;

    @Pattern(regexp = "08[789][0-9]{7}")
    private String phoneNumber;

    private String workHours;

    List<Item> itemIds;

}
