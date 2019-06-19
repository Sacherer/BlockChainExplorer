package com.example.demo.mapper;

import com.example.demo.dto.BlockIndexDto;
import com.example.demo.po.Block;

import java.util.List;


public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    Integer selectByEnd();

    List<Block> getBlockIndex();

}