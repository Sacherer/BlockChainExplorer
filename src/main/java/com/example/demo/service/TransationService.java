package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.dto.TransactionSearchDto;

import java.util.List;

public interface TransationService {
    List<TransactionIndexDto> getTxIndex();

    TransactionGetDto getTxDeatil(String txhash);

    TransactionSearchDto seaerchTransactionByTxhash(String txhash, Integer blockchainId);

    AddressDto getAddress(String address);

    double getTotalReceived(String address);

    Integer getTxSize(String address);

    double getfinalBalance(String address);
}
