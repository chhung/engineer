package com.cathaybk.engineer.model;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class CurrencyInfoModel {
    @SerializedName("disclaimer")
    private String disclaimer;
    @SerializedName("charName")
    private String charName;
    @SerializedName("time")
    private Time time;
    @SerializedName("bpi")
    private Bpi bpi;
    
    public CurrencyInfoModel() {}
    
    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }
    
    static class Time {
        @SerializedName("updated")
        String updated;
        @SerializedName("updateISO")
        String updateISO;
        @SerializedName("updateduk")
        String updateduk;
        
        public void setUpdated(String updated) {
            this.updated = updated;
        }
        
        public String getUpdated() {
            return this.updated;
        }
        
        public void setUpdateISO(String iso) {
            this.updateISO = iso;
        }
        
        public String getUpdateISO() {
            return this.updateISO;
        }
        
        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
        
        public String getUpdateduk() {
            return this.updateduk;
        }
    }
    
    public static class Bpi {
        @SerializedName("USD")
        Currency USD;
        @SerializedName("GBP")
        Currency GBP;
        @SerializedName("EUR")
        Currency EUR;
        
        public void setUSD(Currency USD) {
            this.USD = USD;
        }
        
        public Currency getUSD() {
            return this.USD;
        }

        public Currency getGBP() {
            return GBP;
        }

        public void setGBP(Currency gBP) {
            GBP = gBP;
        }

        public Currency getEUR() {
            return EUR;
        }

        public void setEUR(Currency eUR) {
            EUR = eUR;
        }
    }
    
    public static class Currency {
        @SerializedName("code")
        String code;
        @SerializedName("symbol")
        String symbol;
        @SerializedName("rate")
        String rate;
        @SerializedName("description")
        String description;
        @SerializedName("rate_float")
        BigDecimal rateFloat;
        
        public void setCode(String code) {
            this.code = code;
        }
        
        public String getCode() {
            return this.code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getRateFloat() {
            return rateFloat;
        }

        public void setRateFloat(BigDecimal rateFloat) {
            this.rateFloat = rateFloat;
        }
    }

    
}
