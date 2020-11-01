package com.technicaltest.stockservice.facade;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.entity.StockEntity;
import com.technicaltest.stockservice.mapper.StockMapper;
import com.technicaltest.stockservice.service.StockService;
import com.technicaltest.stockservice.utils.Utils;
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

    public StockData create(StockData stockData) {
        StockEntity requestBody = stockMapper.stockDataToStockEntity(stockData);
        if(!Utils.isEmpty(requestBody.getId())){
            requestBody.setId(null);
        }
        StockEntity stock = stockService.save(requestBody);
        return stockMapper.stockEntityToStockData(stock);
    }

    public StockData edit(Long stockId,StockData stockData) throws Exception {
        StockEntity existing = stockService.getById(stockId);
        if(Utils.isEmpty(existing.getId())){
            throw new Exception("Stock not found");
        }
        StockEntity requestBody = stockMapper.stockDataToStockEntity(stockData);
        requestBody.setId(existing.getId());

        StockEntity stock = stockService.save(requestBody);
        return stockMapper.stockEntityToStockData(stock);
    }

    public void delete(Long stockId) {
        stockService.delete(stockId);
    }

    public void deleteByProductId(Long productId) {
        stockService.deleteByProductId(productId);
    }
}
