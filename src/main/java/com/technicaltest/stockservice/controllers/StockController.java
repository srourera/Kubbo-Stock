package com.technicaltest.stockservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StockController {
    private static final String SERVICE_NAME = "Stock Service";
    private static final String RESPONSE_EXAMPLE = "Hello world!";

    @GetMapping
    ResponseEntity<Map<String, String>> getStocks(){
        Map<String, String> body = new HashMap<>();
        body.put(SERVICE_NAME, RESPONSE_EXAMPLE);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
