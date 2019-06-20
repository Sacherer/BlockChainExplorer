package com.example.demo.controller;

import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.po.Block;
import com.example.demo.service.BlockService;
import com.example.demo.vo.TxDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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
        BlockDetailDto blockDetailDto = blockService.blockDetail(blockhash);

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
        BlockIndexDto blockIndexDto = new BlockIndexDto();
        blockIndexDto.setBlockhash("00000000000000000018165ff0bbbc2a93493c693d45dd65c6a8dcbb881f51fb");
        blockIndexDto.setHeight(580770);
        blockIndexDto.setMiner("SlushPo1ol");
        blockIndexDto.setSize((long)1225464);
        blockIndexDto.setTime(new Date().getTime());
        blockIndexDto.setTransactions(2867);
        blockIndexDtos.add(blockIndexDto);

        BlockIndexDto blockIndexDto2 = new BlockIndexDto();
        blockIndexDto2.setBlockhash("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55af");
        blockIndexDto2.setHeight(580770);
        blockIndexDto2.setMiner("Slush1Pool");
        blockIndexDto2.setSize((long)1225464);
        blockIndexDto2.setTime(new Date().getTime());
        blockIndexDto2.setTransactions(2867);
        blockIndexDtos.add(blockIndexDto2);
        return blockIndexDtos;
    }
}
