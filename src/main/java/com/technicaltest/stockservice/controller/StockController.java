package com.technicaltest.stockservice.controller;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.facade.StockFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class StockController {

    @Autowired
    StockFacade stockFacade;

    @GetMapping(
            value = "/{productId}"
    )
    ResponseEntity<List<StockData>> getStockByProductId(@PathVariable Long productId){
        return new ResponseEntity<>(stockFacade.getByProductId(productId), HttpStatus.OK);
    }
}
