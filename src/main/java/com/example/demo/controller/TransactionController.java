package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.ExchangeRateApi;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/tx")
public class TransactionController {
    @Autowired
    private TransationService transationService;
    @Autowired
    private ExchangeRateApi exchangeRateApi;

    @RequestMapping("/txIndex")
    public List<TransactionIndexDto> txIndex(){
        List<TransactionIndexDto> transactionIndexDtos = transationService.getTxIndex();
        return transactionIndexDtos;
    }

    @RequestMapping("/moreTx")
    public List<TransactionIndexDto> moreTx(){
        List<TransactionIndexDto> transactionIndexDtos = transationService.getMoreTx();
        return transactionIndexDtos;
    }

    @RequestMapping("/txDeatil/{txhash}")
    public TransactionGetDto txDeatil(@PathVariable String txhash){
        TransactionGetDto txDeatil = transationService.getTxDeatil(txhash);
        return txDeatil;
    }

    @RequestMapping("/getAddress/{address}")
    public AddressDto getAddress(@PathVariable String address){
        AddressDto address1 = transationService.getAddress(address);
        return address1;
    }

    @RequestMapping("/getRate")
    public Double getRate(){
        JSONObject rate = exchangeRateApi.getRate();
        JSONObject usd = rate.getJSONObject("USD");
        Double last = usd.getDouble("last");
        return last;
    }

}
