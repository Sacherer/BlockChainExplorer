package com.example.demo.mapper;

import com.example.demo.po.Block;
import org.springframework.stereotype.Repository;
@Repository
public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    Integer selectByEnd();
}