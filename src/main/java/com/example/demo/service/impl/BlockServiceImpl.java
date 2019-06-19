package com.example.demo.service.impl;

import com.example.demo.dto.BlockIndexDto;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.po.Block;
import com.example.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;
    @Override
    public List<BlockIndexDto> getBlockIndex() throws Throwable {
        List<Block> blocks = blockMapper.getBlockIndex();
        List<BlockIndexDto> blockIndexDtos = new ArrayList<>();
        for (Block block : blocks) {
            BlockIndexDto blockIndexDto = new BlockIndexDto();
            blockIndexDto.setTime(block.getTime().getTime());
            blockIndexDto.setMiner(block.getMiner());
            blockIndexDto.setBlockhash(block.getBlockhash());
            blockIndexDto.setHeight(block.getHeight());
            blockIndexDto.setTransactions(block.getTransactions());
            blockIndexDto.setSize(block.getSize());
            blockIndexDtos.add(blockIndexDto);
        }
        return blockIndexDtos;
    }
}
