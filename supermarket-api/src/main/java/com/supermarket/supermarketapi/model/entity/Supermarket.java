package com.supermarket.supermarketapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supermarket {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "supermarket_id", strategy = "uuid2")
    @Column(name = "supermarket_id", unique = true)
    private String id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String workHours;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "supermarket_item", joinColumns = {@JoinColumn(name = "supermarket_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> itemIds;

}
