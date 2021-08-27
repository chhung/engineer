package com.cathaybk.engineer.utility.net;

import java.net.URI;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientImpl {
    @Autowired @Qualifier("restfulWithSSL")
    private RestTemplate restful;

    public String doHttpGet(String url) {
        ResponseEntity<String> response = null;
        try {
            URI uri = new URI(url);
            response = restful.getForEntity(uri, String.class);
            if (response.getStatusCode() == HttpStatus .OK) {
                return response.getBody();
            }
        } catch (Exception ex) {
            System.out.println(ExceptionUtils.getStackTrace(ex));
        }
        
        System.out.println("response status code:" + response.getStatusCode());
        System.out.println("response header:" + response.getHeaders().entrySet());
        return "";
    }
}
