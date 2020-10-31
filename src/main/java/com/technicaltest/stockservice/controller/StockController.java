package com.technicaltest.stockservice.controller;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.facade.StockFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockData> createStock(@RequestBody StockData stock){
        return new ResponseEntity<>(stockFacade.create(stock),HttpStatus.CREATED);
    }

    @PutMapping(
            value = "/{stockId}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StockData> editStock(@PathVariable Long stockId, @RequestBody StockData stock) throws Exception {
        return new ResponseEntity<>(stockFacade.edit(stockId, stock),HttpStatus.CREATED);
    }
}
