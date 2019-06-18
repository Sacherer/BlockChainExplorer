package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
import com.example.demo.api.JsonRpcApi;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockChainApi blockChainApi;

    @Autowired
    private JsonRpcApi jsonRpcApi;

    @Override
    public List<BlockIndexDto> getBlockIndex() throws Throwable {
        ArrayList<BlockIndexDto> blocks = new ArrayList<>();
        JSONObject chinInfo = blockChainApi.getChinInfo();
        Integer height = chinInfo.getInteger("blocks")-5;
        JSONObject blockhashByHeight = blockChainApi.getBlockhashByHeight(height);
        String blockhash = blockhashByHeight.getString("blockhash");
        List<JSONObject> blockHeaders = blockChainApi.getBlockHeaders(5, blockhash);
        for (JSONObject blockHeader : blockHeaders) {
            JSONObject block = jsonRpcApi.getBlockByHash(blockHeader.getString("hash"));
            Long size = block.getLong("size");
            BlockIndexDto blockIndexDto = new BlockIndexDto();
            blockIndexDto.setSize(size);
            blockIndexDto.setTransactions(blockHeader.getInteger("nTx"));
            blockIndexDto.setHeight(blockHeader.getInteger("height"));
            blockIndexDto.setBlockhash(blockHeader.getString("hash"));
            blockIndexDto.setTime(blockHeader.getLong("time"));
            //todo
            blockIndexDto.setMiner(null);
            blocks.add(blockIndexDto);
        }
        return blocks;
    }
}
