package com.supermarket.supermarketapi.model.dto;

import com.supermarket.supermarketapi.model.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseSupermarketDto {

    private String supermarketId;

    private List<String> itemIds;

    private PaymentType paymentType;

    private Double cashAmount;

}
