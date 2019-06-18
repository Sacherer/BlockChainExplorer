package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
import com.example.demo.api.JsonRpcApi;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;
    @Override
    public List<BlockIndexDto> getBlockIndex() throws Throwable {
        List<BlockIndexDto> blocks = blockMapper.getBlockIndex();
        return blocks;
    }
}
