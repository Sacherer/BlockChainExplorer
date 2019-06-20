package com.example.demo.service.impl;

import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.po.Transaction;
import com.example.demo.service.BlockService;
import com.example.demo.service.TransationService;
import com.example.demo.vo.Txs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransationServiceImpl implements TransationService {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private BlockService blockService;
    @Override
    public List<TransactionIndexDto> getTxIndex() {
        ArrayList<TransactionIndexDto> transactionIndexDtos = new ArrayList<>();
        List<Transaction>  transactions = transactionMapper.getTxIndex();
        for (Transaction transaction : transactions) {
            TransactionIndexDto transactionIndexDto = new TransactionIndexDto();
            transactionIndexDto.setTxhash(transaction.getTxhash());
            transactionIndexDto.setTotalOutput(transaction.getTotalOutput());
            transactionIndexDto.setTime(transaction.getTime().getTime());
            transactionIndexDtos.add(transactionIndexDto);
        }
        return transactionIndexDtos;
    }

    @Override
    public TransactionGetDto getTxDeatil(String txhash) {
        Transaction transaction = transactionMapper.selectByPrimaryKey(txhash);
        TransactionGetDto transactionGetDto = new TransactionGetDto();
        transactionGetDto.setConfirm(transaction.getConfirm());
        transactionGetDto.setWeight(transaction.getWeight());
        transactionGetDto.setTxhash(transaction.getTxhash());
        transactionGetDto.setTotalOutput(transaction.getTotalOutput());
        transactionGetDto.setTotalInput(transaction.getTotalInput());
        transactionGetDto.setSize(transaction.getSize());
        transactionGetDto.setFees(transaction.getFees());
        transactionGetDto.setTime(transaction.getTime().getTime());
        ArrayList<Txs> txs1 = new ArrayList<>();
        Txs txs = blockService.getTxs(transaction);
        txs1.add(txs);
        transactionGetDto.setTxs(txs1);
        return transactionGetDto;
    }
}
