package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

public interface BitconinSyncService {
    void syncBlockData(String blockHash);
    void syncTx(JSONObject blocks,JSONObject txObject);
}
