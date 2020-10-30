package com.technicaltest.stockservice.dto;

import com.technicaltest.stockservice.utils.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockData {

    private Long id;

    private Long productId;

    private Long warehouseId;

    private Integer quantity;

    private StatusEnum status;

}
