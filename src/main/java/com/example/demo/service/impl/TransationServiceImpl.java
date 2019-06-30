package com.example.demo.service.impl;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.dto.TransactionGetDto;
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
        List<Transaction>  transactions = transactionMapper.getTxIndex();
        if(transactions!=null){
            List<TransactionIndexDto> transationIndexDto = getTransationIndexDto(transactions);
            return transationIndexDto;
        }
        return null;
    }

    @Override
    public List<TransactionIndexDto> getTransationIndexDto(List<Transaction> transactions) {
        List<TransactionIndexDto> transactionIndexDtos = new ArrayList<>();
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
        TransactionGetDto transactionGetDto = new TransactionGetDto();
        Transaction transaction = transactionMapper.selectByPrimaryKey(txhash);
        if(transaction!=null){
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
            Block block = blockMapper.selectByPrimaryKey(transaction.getBlockhash());
            transactionGetDto.setHeight(block.getHeight());
            transactionGetDto.setTxs(txs1);
            return transactionGetDto;
        }
        return null;
    }

    @Override
    public TransactionGetDto seaerchTransactionByTxhash(String txhash, Integer blockchainId) {
        TransactionGetDto transactionGetDto = new TransactionGetDto();
        Transaction transaction = transactionMapper.selectByPrimaryKey(txhash);
        if(transaction!=null){
            transactionGetDto.setConfirm(transaction.getConfirm());
            transactionGetDto.setFees(transaction.getFees());
            transactionGetDto.setSize(transaction.getSize());
            transactionGetDto.setTime(transaction.getTime().getTime());
            transactionGetDto.setTotalInput(transaction.getTotalInput());
            transactionGetDto.setTotalOutput(transaction.getTotalOutput());
            transactionGetDto.setTxhash(transaction.getTxhash());
            transactionGetDto.setWeight(transaction.getWeight());
            ArrayList<Txs> txs1 = new ArrayList<>();
            Txs txs = blockService.getTxs(transaction);
            txs1.add(txs);
            transactionGetDto.setTxs(txs1);
            Block block = blockMapper.searchBlockByHash(transaction.getBlockhash(),blockchainId);
            transactionGetDto.setHeight(block.getHeight());
            return transactionGetDto;
        }
        return null;
    }

    @Override
    public AddressDto getAddress(String address) {
        List<TransactionDetail> transactionDetails = transactionDetailMapper.getByAddress(address);
        if(transactionDetails.size()!=0){
            AddressDto addressDto = new AddressDto();
            addressDto.setAddress(address);
            Double totalRecevied = getTotalReceived(address);
            addressDto.setTotalReceived(totalRecevied);
            Integer txSize = getTxSize(address);
            addressDto.setTxSize(txSize);
            Double finalBalance = getfinalBalance(address);
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
    public Double getTotalReceived(String address) {
        return transactionDetailMapper.getTotalReceived(address);
    }

    @Override
    public Integer getTxSize(String address) {
        return transactionDetailMapper.getTxSize(address);
    }

    @Override
    public Double getfinalBalance(String address) {
        return transactionDetailMapper.getfinalBalance(address);
    }

    @Override
    public List<TransactionIndexDto> getMoreTx() {
        List<Transaction>  transactions = transactionMapper.getMoreTx();
        if(transactions!=null){
            List<TransactionIndexDto> transationIndexDto = getTransationIndexDto(transactions);
            return transationIndexDto;
        }
        return null;
    }
}
