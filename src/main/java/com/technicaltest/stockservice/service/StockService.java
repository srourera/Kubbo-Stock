package com.technicaltest.stockservice.service;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.entity.StockEntity;
import com.technicaltest.stockservice.mapper.StockMapper;
import com.technicaltest.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<StockEntity> getByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }
}
