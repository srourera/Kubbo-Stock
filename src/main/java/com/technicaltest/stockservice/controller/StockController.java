package com.technicaltest.stockservice.controller;

import com.technicaltest.stockservice.dto.StockData;
import com.technicaltest.stockservice.facade.StockFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockFacade stockFacade;

    @GetMapping
    ResponseEntity<List<StockData>> getStocks(){
        return new ResponseEntity<>(stockFacade.getAll(), HttpStatus.OK);
    }
}
