package com.example.demo.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.ExchangeRateApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchageRateApiImpl implements ExchangeRateApi {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JSONObject getRate() {
        JSONObject forObject = restTemplate.getForObject("https://blockchain.info/ticker", JSONObject.class);
        return forObject;
    }
}
