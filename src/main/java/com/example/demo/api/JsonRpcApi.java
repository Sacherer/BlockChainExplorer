package com.example.demo.api;

import com.alibaba.fastjson.JSONObject;

public interface JsonRpcApi {
    JSONObject getBlockByHash(String blockhash) throws Throwable;
    JSONObject getAddressByHash(String address) throws Throwable;
}
