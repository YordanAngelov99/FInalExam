package com.supermarket.supermarketapi.model.entity;

import com.supermarket.supermarketapi.model.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "purchase_id", strategy = "uuid2")
    @Column(name = "purchase_id", unique = true)
    private String id;

    @NotBlank
    private String superMarketId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = true)
    private Double cashAmount;

    private Double totalPrice;

    private Double totalPriceChange;

    private LocalDateTime timePurchased;


}
