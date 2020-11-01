package com.technicaltest.stockservice.service;

import com.technicaltest.stockservice.entity.StockEntity;
import com.technicaltest.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public StockEntity getById(Long stockId) {
        return stockRepository.findById(stockId).orElse(new StockEntity());
    }

    public List<StockEntity> getByProductId(Long productId) {
        return stockRepository.findByProductId(productId);
    }

    public StockEntity save(StockEntity productEntity) {
        return stockRepository.save(productEntity);
    }

    public void delete(Long stockId) {
        stockRepository.deleteById(stockId);
    }

    public void deleteByProductId(Long productId) {
        stockRepository.deleteByProductId(productId);
    }
}
