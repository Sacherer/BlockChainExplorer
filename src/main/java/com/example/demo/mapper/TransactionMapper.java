package com.example.demo.mapper;

import com.example.demo.po.Transaction;

import java.util.List;


public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> selectByBlockHash(String blockhash);

    List<Transaction> getTxIndex();
}