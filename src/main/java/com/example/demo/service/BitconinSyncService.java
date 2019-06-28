package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;

public interface BitconinSyncService {
    void syncBlockChain(String blockHash);
    String syncBlockData(String tempHash);
    void syncTx(JSONObject blocks,JSONObject txObject);
    void vout(String txid,JSONObject voutObject);
    void vint(String txid,JSONObject vinObject);
    void syncTxDetail(String txid,JSONObject txObject);
    Double getTxTotalInput(String txid);
    Double getTxTotalOutput(String txid);
    Double getBlockOutputTotal(String blockhash);
}
