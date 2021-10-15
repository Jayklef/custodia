package com.jayklef.custodia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long itemId;
    private String itemName;
    private Integer itemValue;

    @ManyToOne(
            cascade = CascadeType.ALL
    )

    @JoinColumn(
            name = "category_id",
            referencedColumnName = "categoryId"
    )
    private Category category;

    @ManyToOne(
            cascade = CascadeType.ALL
    )

    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"
    )
    private Client client;

    @Enumerated(value = EnumType.STRING)
    private RiskLevel riskLevel;
}
