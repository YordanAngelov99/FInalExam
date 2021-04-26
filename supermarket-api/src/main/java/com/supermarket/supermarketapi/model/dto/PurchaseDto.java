package com.supermarket.supermarketapi.model.dto;

import com.supermarket.supermarketapi.model.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseDto {

    @NotBlank
    private String superMarketId;

    @NotNull
    private PaymentType paymentType;

    @Column(nullable = true)
    private Double cashAmount;

    private Double totalPrice;

    private Double totalPriceChange;

    private LocalDateTime timePurchased;


}
