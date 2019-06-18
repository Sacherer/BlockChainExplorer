package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
import com.example.demo.api.JsonRpcApi;
import com.example.demo.service.BitconinSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/temp")
public class TempController {
    @Autowired
    private BlockChainApi blockChainApi;
    @Autowired
    private JsonRpcApi jsonRpcApi;
    @Autowired
    private BitconinSyncService syncService;
    @RequestMapping("/test")
    public void getTest() throws Throwable {
//        JSONObject chinInfo = blockChainApi.getChinInfo();
//        String s = chinInfo.toJSONString();

//        JSONObject transactions = blockChainApi.getTransactions("bcb39771e13d90a376aa1fd81df48f5647d34bcf62510c1cfc4645000a178e21");
//        String s = transactions.toJSONString();

//        JSONObject blockhashByHeight = blockChainApi.getBlockhashByHeight(1543972);
//        String s = blockhashByHeight.toJSONString();

//        List<JSONObject> blockHeaders = blockChainApi.getBlockHeaders(4, "00000000000003899051eca575b4d28f896d8d0946e1346bc94a278dcb533c6e");


//        JSONObject blocks = blockChainApi.getBlocks("000000000000034e8361c788833e6213059ef46bb09744188d9278fde2a00945");
//        String s = blocks.toJSONString();

//        JSONObject mempoolContents = blockChainApi.getMempoolContents();
//        String s = mempoolContents.toJSONString();

//        JSONObject mempoolInfo = blockChainApi.getMempoolInfo();
//        String s = mempoolInfo.toJSONString();

//        JSONObject nodetailBlocks = blockChainApi.getNodetailBlocks("000000000000034e8361c788833e6213059ef46bb09744188d9278fde2a00945");
//        String s = nodetailBlocks.toJSONString();

//        JSONObject blockByHash = jsonRpcApi.getBlockByHash("00000000000000181f6fdb2afb7a918ad6535de8d81ea856f57ca7c74b84f705");
//        String s = blockByHash.toJSONString();
//        JSONObject getAddress = jsonRpcApi.getAddressByHash("n2Byre52T9PZ6n8nbLVX7HgSuymW9kNxgj");
//        String s = getAddress.toJSONString();
//        return  blockHeaders;
        syncService.syncBlockData("000000000000038c79111230af144f5dffb8be3b1e1686c09346f213fac00ef0");
    }

}
