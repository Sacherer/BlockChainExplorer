package com.example.demo.service;

import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;

import java.util.List;

public interface TransationService {
    List<TransactionIndexDto> getTxIndex();

    TransactionGetDto getTxDeatil(String txhash);
}
