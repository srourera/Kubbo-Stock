package com.technicaltest.stockservice.repository;

import com.technicaltest.stockservice.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<StockEntity, Long> {

    List<StockEntity> findByProductId(Long productId);

}