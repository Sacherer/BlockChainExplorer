package com.example.demo.mapper;

import com.example.demo.po.BlockChain;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockChainMapper {
    int deleteByPrimaryKey(Integer blockchainId);

    int insert(BlockChain record);

    int insertSelective(BlockChain record);

    BlockChain selectByPrimaryKey(Integer blockchainId);

    int updateByPrimaryKeySelective(BlockChain record);

    int updateByPrimaryKey(BlockChain record);
}