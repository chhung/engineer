package com.cathaybk.engineer.utility;

import org.springframework.stereotype.Service;

import com.cathaybk.engineer.model.CurrencyInfoModel;
import com.google.gson.Gson;

@Service
public class ConvertCondesk {
    
    public CurrencyInfoModel getObjFromBody(String body) {
        Gson gson = new Gson();
        CurrencyInfoModel currencyInfo = gson.fromJson(body, CurrencyInfoModel.class);
        return currencyInfo;
    }
    
    public String toJsonFromModel(CurrencyInfoModel model) {
    	Gson gson = new Gson();
    	return gson.toJson(model);
    }
}
