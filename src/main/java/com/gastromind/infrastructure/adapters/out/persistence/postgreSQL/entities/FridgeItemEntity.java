package com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fridge_items")
public class FridgeItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal quantity;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @ManyToOne
    @JoinColumn(name = "fridge_id", nullable = false)
    private FridgeEntity fridge;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

}
