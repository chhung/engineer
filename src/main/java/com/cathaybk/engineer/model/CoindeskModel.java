package com.cathaybk.engineer.model;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class CoindeskModel {
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("currency_info")
    private String currencyInfo;
    
    public static class CurrencyInfo {
        @SerializedName("code")
        String code;
        @SerializedName("code_chinese")
        String codeChinese;
        @SerializedName("exchange_rate")
        BigDecimal exchangeRate;
    }
}
