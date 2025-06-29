package com.order.orderService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {

    private RestTemplate restTemplate=new RestTemplate();

    public String getToken()
    {
        String url = "http://localhost:8080/auth/login?userName=admin&password=password";

        return restTemplate.getForObject(url,String.class);
    }

}
