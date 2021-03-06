package com.technicaltest.stockservice.entity;

import com.technicaltest.stockservice.utils.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long warehouseId;

    private Integer quantity;

    private StatusEnum status;

    @PrePersist
    public void prePersist() {
        this.id = null;
    }
}