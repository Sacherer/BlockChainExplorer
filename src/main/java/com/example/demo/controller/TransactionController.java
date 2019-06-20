package com.example.demo.controller;

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

    @RequestMapping("/txIndex")
    public List<TransactionIndexDto> txIndex(){
        List<TransactionIndexDto> transactionIndexDtos = transationService.getTxIndex();
        return transactionIndexDtos;
    }
    @RequestMapping("/txDeatil/{txhash}")
    public TransactionGetDto txDeatil(@PathVariable String txhash){
        TransactionGetDto transactionGetDto = transationService.getTxDeatil(txhash);
        return transactionGetDto;
    }
}
