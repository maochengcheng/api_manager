package com.guanting.manager.service.system;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClient {

    private static String baseUrl="http://127.0.0.1:8081/";
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(baseUrl+url,String.class);
        return response.getBody();
    }
}
