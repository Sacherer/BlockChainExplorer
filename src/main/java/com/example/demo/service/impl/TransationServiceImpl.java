package com.example.demo.service.impl;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.TransactionGetDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.dto.TransactionSearchDto;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.mapper.TransactionDetailMapper;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.po.Block;
import com.example.demo.po.Transaction;
import com.example.demo.po.TransactionDetail;
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
    private BlockMapper blockMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

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

    @Override
    public TransactionSearchDto seaerchTransactionByTxhash(String txhash, Integer blockchainId) {
        TransactionSearchDto transactionSearchDto = new TransactionSearchDto();
        Transaction transaction = transactionMapper.selectByPrimaryKey(txhash);
        if(transaction!=null){
            transactionSearchDto.setConfirm(transaction.getConfirm());
            transactionSearchDto.setFees(transaction.getFees());
            transactionSearchDto.setSize(transaction.getSize());
            transactionSearchDto.setTime(transaction.getTime().getTime());
            transactionSearchDto.setTotalInput(transaction.getTotalInput());
            transactionSearchDto.setTotalOutput(transaction.getTotalOutput());
            transactionSearchDto.setTxhash(transaction.getTxhash());
            transactionSearchDto.setWeight(transaction.getWeight());
            ArrayList<Txs> txs1 = new ArrayList<>();
            Txs txs = blockService.getTxs(transaction);
            txs1.add(txs);
            transactionSearchDto.setTxs(txs1);
            Block block = blockMapper.searchBlockByHash(transaction.getBlockhash(),blockchainId);
            transactionSearchDto.setHeight(block.getHeight());
            return transactionSearchDto;
        }
        return null;
    }

    @Override
    public AddressDto getAddress(String address) {
        List<TransactionDetail> transactionDetails = transactionDetailMapper.getByAddress(address);
        if(transactionDetails.size()!=0){
            AddressDto addressDto = new AddressDto();
            addressDto.setAddress(address);
            double totalRecevied = getTotalReceived(address);
            addressDto.setTotalReceived(totalRecevied);
            Integer txSize = getTxSize(address);
            addressDto.setTxSize(txSize);
            double finalBalance = getfinalBalance(address);
            addressDto.setFinalBalance(finalBalance);
            ArrayList<Txs> txs = new ArrayList<>();
            for (TransactionDetail tx : transactionDetails) {
                Transaction transaction = transactionMapper.selectByPrimaryKey(tx.getTxid());
                Txs txs1 = blockService.getTxs(transaction);
                txs.add(txs1);
            }
            addressDto.setTxs(txs);
            return addressDto;
        }
        return null;
    }

    @Override
    public double getTotalReceived(String address) {
        return transactionDetailMapper.getTotalReceived(address);
    }

    @Override
    public Integer getTxSize(String address) {
        return transactionDetailMapper.getTxSize(address);
    }

    @Override
    public double getfinalBalance(String address) {
        return transactionDetailMapper.getfinalBalance(address);
    }
}
