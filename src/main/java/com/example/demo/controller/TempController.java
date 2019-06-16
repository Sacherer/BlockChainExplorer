package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/temp")
public class TempController {
    @Autowired
    private BlockChainApi blockChainApi;
    @RequestMapping("/test")
    public String getTest(){
//        JSONObject chinInfo = blockChainApi.getChinInfo();
//        return chinInfo.toJSONString();

//        JSONObject transactions = blockChainApi.getTransactions("12ba70fe122e4e17411100dc349692bf25eeb1222c837b85b93f5a2f358a6197");
//        String s = transactions.toJSONString();

//        JSONObject blockhashByHeight = blockChainApi.getBlockhashByHeight("580994");
//        String s = blockhashByHeight.toJSONString();

//        JSONObject blockHeaders = blockChainApi.getBlockHeaders("2", "00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb");
//        String s = blockHeaders.toJSONString();

//        JSONObject blocks = blockChainApi.getBlocks("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb");
//        String s = blocks.toJSONString();

//        JSONObject mempoolContents = blockChainApi.getMempoolContents();
//        String s = mempoolContents.toJSONString();

//        JSONObject mempoolInfo = blockChainApi.getMempoolInfo();
//        String s = mempoolInfo.toJSONString();

        JSONObject nodetailBlocks = blockChainApi.getNodetailBlocks("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb");
        String s = nodetailBlocks.toJSONString();


        return s;
    }
}
