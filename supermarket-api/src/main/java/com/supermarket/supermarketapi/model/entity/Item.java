package com.supermarket.supermarketapi.model.entity;

import com.supermarket.supermarketapi.model.enums.ItemType;
import lombok.AllArgsConstructor;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "item_id", unique = true)
    private String id;

    @NotBlank
    @Column
    private String name;

    @NotNull
    @Column
    private Double price;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
}
