package com.cathaybk.engineer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cathaybk.engineer.application.CoindeskService;
import com.cathaybk.engineer.application.ThirdPartyService;
import com.cathaybk.engineer.dao.CurrencyMappingDao;
import com.cathaybk.engineer.model.CoindeskModel;
import com.cathaybk.engineer.model.CurrencyMappingModel;

@RestController
@RequestMapping(value = "/api")
public class CoindeskController {
    @Autowired
    private CoindeskService coin;
    
    @Autowired
    private CurrencyMappingDao currencyMappingDao;
    
    @Autowired
    private ThirdPartyService thirdPartyService;
    
    @GetMapping(value = "/v1/query/{code}", produces = "application/json; charset=utf-8")
    public CoindeskModel getCurrencyMapping(@PathVariable("code") String code) {
    	String content = thirdPartyService.getCurrentPrice();
    	CoindeskModel model = coin.coinMap(code, content);
        return model;
    }
    
    @GetMapping(value = "/v1/currentprice", produces = "application/json; charset=utf-8")
    public String getCurrentPrice() {
    	return thirdPartyService.getCurrentPrice();
    }
    
    @GetMapping(value = "/v1/delete/{code}", produces = "application/json; charset=utf-8")
    public void deleteByCode(@PathVariable("code") String code) {
    	coin.deleteByCode(code);
    	
    }
    
    @GetMapping(value = "/v1/update/{code}", produces = "application/json; charset=utf-8")
    public CoindeskModel updateByCode(@PathVariable("code") String code, @RequestParam("chinese") String chinese) {
    	coin.updateByCode(chinese, code);
    	String content = thirdPartyService.getCurrentPrice();
    	return coin.coinMap(code, content);
    }
    
    @PostMapping(value = "/v1/save", produces = "application/json; charset=utf-8")
    public void save(@RequestBody CurrencyMappingModel requestBody) {
    	coin.save(requestBody.getCode(), requestBody.getChinese());
    }
    
    @GetMapping(value = "/v1/allmapping", produces = "application/json; charset=utf-8")
    public List<CurrencyMappingModel> getAll() {
    	return currencyMappingDao.findAll();
    }
}
