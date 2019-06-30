package com.example.demo.service;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.dto.TransactionGetDto;
import com.example.demo.po.Transaction;

import java.util.List;

public interface TransationService {
    List<TransactionIndexDto> getTxIndex();

    List<TransactionIndexDto> getTransationIndexDto(List<Transaction>  transactions);

    TransactionGetDto getTxDeatil(String txhash);

    TransactionGetDto seaerchTransactionByTxhash(String txhash, Integer blockchainId);

    AddressDto getAddress(String address);

    Double getTotalReceived(String address);

    Integer getTxSize(String address);

    Double getfinalBalance(String address);

    List<TransactionIndexDto> getMoreTx();

}
