package com.example.demo.service;

import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.po.Block;
import com.example.demo.po.Transaction;
import com.example.demo.vo.Txs;

import java.util.List;

public interface BlockService {
    List<BlockIndexDto> getBlockIndex() throws Throwable;

    Block getBlockByHeight(Integer height);

    BlockDetailDto blockDetail(String blockhash);

    Txs getTxs(Transaction transaction);
}
