package com.example.demo.controller;

import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.po.Block;
import com.example.demo.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/block")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @RequestMapping("/blockIndex")
    public List<BlockIndexDto> blockIndex() throws Throwable {
        List<BlockIndexDto> blockIndexDtos =blockService.getBlockIndex();

        return blockIndexDtos;
    }

    @RequestMapping("/blockDetail/{blockhash}")
    public BlockDetailDto blockDetail(@PathVariable String blockhash){
        BlockDetailDto blockDetailDto = blockService.getBlockByHash(blockhash);

        return blockDetailDto;
    }

    @RequestMapping("/getBlockByHeight/{height}")
    public Block getBlockByHeight(@PathVariable Integer height){
        Block block =  blockService.getBlockByHeight(height);
        return block;
    }
    @RequestMapping("/blockList/{startDate}/{endDate}")
    public List<BlockIndexDto> blockList(@PathVariable String startDate,@PathVariable String endDate){
        ArrayList<BlockIndexDto> blockIndexDtos = new ArrayList<>();
        return blockIndexDtos;
    }
}
