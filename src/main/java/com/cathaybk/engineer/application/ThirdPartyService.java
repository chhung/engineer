package com.cathaybk.engineer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathaybk.engineer.utility.net.ClientImpl;

@Service
public class ThirdPartyService {
	@Autowired
    ClientImpl client;
	
	public String getCurrentPrice() {
    	return client.doHttpGet("https://api.coindesk.com/v1/bpi/currentprice.json"); 
    }
}
