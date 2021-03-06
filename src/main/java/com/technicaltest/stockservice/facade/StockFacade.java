package com.technicaltest.stockservice.facade;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.entity.StockEntity;
import com.technicaltest.stockservice.mapper.StockMapper;
import com.technicaltest.stockservice.service.StockService;
import com.technicaltest.stockservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public StockData edit(Long stockId,StockData stockData) {
        StockEntity existing = stockService.getById(stockId);
        if(Utils.isEmpty(existing.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This stock doens't exist");
        }
        StockEntity requestBody = stockMapper.stockDataToStockEntity(stockData);
        requestBody.setId(existing.getId());

        StockEntity stock = stockService.save(requestBody);
        return stockMapper.stockEntityToStockData(stock);
    }

    public void delete(Long stockId) {
        try {
            stockService.delete(stockId);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This stock doens't exist");
        }
    }

    public void deleteByProductId(Long productId) {
        stockService.deleteByProductId(productId);
    }
}
