package com.cathaybk.engineer.model;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class CoindeskModel {
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("currency_info")
    private CurrencyInfo currencyInfo;
    
    public CoindeskModel() {super();}
    public CoindeskModel(String updateTime, CurrencyInfo currencyInfo) {
		super();
		this.updateTime = updateTime;
		this.currencyInfo = currencyInfo;
	}

	@Data
    public static class CurrencyInfo {
        @SerializedName("code")
        String code;
        @SerializedName("code_chinese")
        String codeChinese;
        @SerializedName("exchange_rate")
        BigDecimal exchangeRate;
		
        public CurrencyInfo() {super();}
        public CurrencyInfo(String code, String codeChinese, BigDecimal exchangeRate) {
    		super();
    		this.code = code;
    		this.codeChinese = codeChinese;
    		this.exchangeRate = exchangeRate;
    	}
    }
}
