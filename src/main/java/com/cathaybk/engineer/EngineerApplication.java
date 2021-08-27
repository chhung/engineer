package com.cathaybk.engineer;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cathaybk.engineer.model.CurrencyInfoModel;
import com.cathaybk.engineer.utility.ConvertCondesk;
import com.cathaybk.engineer.utility.net.ClientImpl;

@SpringBootApplication
public class EngineerApplication implements ApplicationRunner {
    @Autowired
    ClientImpl client;
    
    @Autowired
    ConvertCondesk convert;
    
	public static void main(String[] args) {
		SpringApplication.run(EngineerApplication.class, args);
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(CurrencyInfoModel.class);
        
        
        CurrencyInfoModel currencyInfo = null;
        String body = client.doHttpGet("https://api.coindesk.com/v1/bpi/currentprice.json");
        System.out.println(body);
        currencyInfo = convert.getObjFromBody(body);
        String usd = currencyInfo.getBpi().getUSD().getCode();
        System.out.println("code=" + usd);
        CurrencyInfoModel.Currency currency = currencyInfo.getBpi().getEUR();
        BigDecimal rate = currency.getRateFloat();
        System.out.println("rate_float=" + rate.toString());
    }

}
