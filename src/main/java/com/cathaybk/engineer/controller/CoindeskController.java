package com.cathaybk.engineer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathaybk.engineer.application.CoindeskService;
import com.cathaybk.engineer.model.CoindeskModel;

@RestController
public class CoindeskController {
    @Autowired
    private CoindeskService coin;
    
    @GetMapping("/currencymapping")
    public CoindeskModel getCurrencyMapping() {
        return coin.coinMap();
    }
}
