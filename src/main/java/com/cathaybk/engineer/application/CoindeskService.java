package com.cathaybk.engineer.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathaybk.engineer.dao.CurrencyMappingDao;
import com.cathaybk.engineer.model.CoindeskModel;
import com.cathaybk.engineer.model.CoindeskModel.CurrencyInfo;
import com.cathaybk.engineer.model.CurrencyInfoModel;
import com.cathaybk.engineer.model.CurrencyMappingModel;
import com.cathaybk.engineer.utility.ConvertCondesk;
import com.cathaybk.engineer.utility.net.ClientImpl;

@Service
public class CoindeskService {
	@Autowired
    ClientImpl client;
    
    @Autowired
    ConvertCondesk convert;
    
    @Autowired
    private CurrencyMappingDao currencyMappingDao;
    
    // query jap to find coin mapping
    private CoindeskModel setCurrencyChinese(String code, BigDecimal rate, CoindeskModel coindesk) {
    	CurrencyInfo currencyInfo = new CurrencyInfo();
    	currencyInfo.setCode(code);
    	currencyInfo.setExchangeRate(rate);
    	CurrencyMappingModel data = currencyMappingDao.findByCode(code);
    	if (!Objects.isNull(data)) {
    		currencyInfo.setCodeChinese(data.getChinese());
    	}
    	
    	coindesk.setCurrencyInfo(currencyInfo);;
    	return coindesk;
    }
    
    public CoindeskModel coinMap(String code, String coindeskContent) {
    	CurrencyInfoModel currencyInfo = null;
        currencyInfo = convert.getObjFromBody(coindeskContent);
        
        CoindeskModel coindesk = new CoindeskModel();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        coindesk.setUpdateTime(localDateTime.format(dtf));
        BigDecimal rate = null;
        switch (code) {
        case "USD":
        	rate = currencyInfo.getBpi().getUSD().getRateFloat();
        	break;
        case "GBP":
        	rate = currencyInfo.getBpi().getGBP().getRateFloat();
        	break;
        case "EUR":	
        	rate = currencyInfo.getBpi().getEUR().getRateFloat();
        	break;
        default:
        	
        }
        coindesk = setCurrencyChinese(code, rate, coindesk);
    	
    	return coindesk;
    }
    
    // insert into
    public String save(String code, String chinese) {
    	String msg = "success";
    	try {
    		currencyMappingDao.insert(code, chinese);
    	} catch (Exception ex) {
    		msg = ex.getMessage();
    	}
    	return msg;
    }
    
    // update
    public String updateByCode(String chinese, String code) {
    	String msg = "success";
    	try {
    		currencyMappingDao.updateByCode(chinese, code);
    	} catch (Exception ex) {
    		msg = ex.getMessage();
    	}
    	return msg;
    }
    
    // delete from
    public String deleteByCode(String code) {
    	String msg = "success";
    	try {
    		int count = currencyMappingDao.deleteByCode(code);
    	} catch (Exception ex) {
    		msg = ex.getMessage();
    	}
    	return msg;
    }
}
