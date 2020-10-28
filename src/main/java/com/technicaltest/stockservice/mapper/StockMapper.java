package com.technicaltest.stockservice.mapper;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.entity.StockEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StockMapper {
    StockData stockEntityToStockData(StockEntity stockEntity);
    StockEntity stockDataToStockEntity(StockData stockData);

    List<StockData> stockEntityListToStockDataList(List<StockEntity> stockEntityList);
    List<StockEntity> stockDataListToStockEntityList(List<StockData> stockDataList);
}