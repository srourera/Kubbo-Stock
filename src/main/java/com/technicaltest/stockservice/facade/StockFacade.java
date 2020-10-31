package com.technicaltest.stockservice.facade;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.entity.StockEntity;
import com.technicaltest.stockservice.mapper.StockMapper;
import com.technicaltest.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockFacade {
    @Autowired
    private StockService stockService;

    @Autowired
    private StockMapper stockMapper;

    public List<StockData> getByProductId(Long productId) {
        List<StockEntity> stock = stockService.getByProductId(productId);
        return stockMapper.stockEntityListToStockDataList(stock);
    }
}
