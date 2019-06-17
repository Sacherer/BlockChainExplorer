package com.example.demo.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.JsonRpcApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Component
public class JsonRpcApiImpl implements JsonRpcApi {

    private JsonRpcHttpClient jsonRpcHttpClient;

    public JsonRpcApiImpl(@Value("${bitcoin.jsonrpc.username}") String username,
                          @Value("${bitcoin.jsonrpc.password}") String password,
                          @Value("${bitcoin.jsonrpc.url}")String url) throws MalformedURLException {
        HashMap<String, String> heards = new HashMap<>();
        String authStrOrig = String.format("%s:%s",username,password);
        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
        String authResult = String.format("Basic %s", authStr);
        heards.put("Authorization",authResult);
        jsonRpcHttpClient = new JsonRpcHttpClient(new URL(url), heards);
    }

    @Override
    public JSONObject getBlockByHash(String blockhash) throws Throwable {
        JSONObject getblock = jsonRpcHttpClient.invoke("getblock", new Object[]{blockhash}, JSONObject.class);

        return getblock;
    }

    @Override
    public JSONObject getAddressByHash(String address) throws Throwable {
        JSONObject getAddress = jsonRpcHttpClient.invoke("getaddressinfo", new Object[]{address}, JSONObject.class);
        return getAddress;
    }
}
