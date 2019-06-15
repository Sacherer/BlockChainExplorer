package com.example.demo.controller;

import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.dto.TransactionIndexDto;
import com.example.demo.po.TransactionDetail;
import com.example.demo.vo.TxDetail;
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

    @RequestMapping("/blockIndex")
    public List<BlockIndexDto> blockIndex(){
        ArrayList<BlockIndexDto> blockIndexDtos = new ArrayList<>();
        BlockIndexDto blockIndexDto = new BlockIndexDto();
        blockIndexDto.setBlockhash("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb");
        blockIndexDto.setHeight(580770);
        blockIndexDto.setMiner("SlushPool");
        blockIndexDto.setSize((long)1225464);
        blockIndexDto.setTime(new Date().getTime());
        blockIndexDto.setTransactions(2867);
        blockIndexDtos.add(blockIndexDto);

        BlockIndexDto blockIndexDto2 = new BlockIndexDto();
        blockIndexDto2.setBlockhash("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55ff");
        blockIndexDto2.setHeight(580770);
        blockIndexDto2.setMiner("SlushPool");
        blockIndexDto2.setSize((long)1225464);
        blockIndexDto2.setTime(new Date().getTime());
        blockIndexDto2.setTransactions(2867);
        blockIndexDtos.add(blockIndexDto2);
        return blockIndexDtos;
    }
    @RequestMapping("/blockDetail/{height}")
    public BlockDetailDto blockDetail(@PathVariable String height){
        BlockDetailDto blockDetailDto = new BlockDetailDto();
        blockDetailDto.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e019eed56030967a6");
        blockDetailDto.setBlockchainId(1);
        blockDetailDto.setBlockhash("00000000000000000018a65ff0bbbc2a93493c693d05dd65c6a8dcbb881f55fb");
        blockDetailDto.setDifficulty((double)1);
        blockDetailDto.setFees(0.8);
        blockDetailDto.setHeight(580770);
        blockDetailDto.setMerkleRoot("5207117cb3ef0635be556974a3c781e17905c0e2d4390aec212b5f6a1110e32b");
        blockDetailDto.setMiner("SlushPool");
        blockDetailDto.setNextBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        blockDetailDto.setOutputTotal(1647.45939539);
        blockDetailDto.setPrevBlockhash("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        blockDetailDto.setTime(new Date().getTime());
        blockDetailDto.setTimestamp(new Date().getTime());
        blockDetailDto.setTransactions(2867);
        blockDetailDto.setSize((long)1225464);
        blockDetailDto.setTxtime(new Date().getTime());
        ArrayList<TxDetail> txDetails = new ArrayList<>();
        TxDetail txDetail = new TxDetail();
        txDetail.setAddress("1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ");
        txDetail.setType((byte)1);
        txDetail.setAmount((double)1);
        txDetails.add(txDetail);
        TxDetail txDetail2 = new TxDetail();
        txDetail2.setAddress("1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ");
        txDetail2.setType((byte)2);
        txDetail2.setAmount((double)1);
        txDetails.add(txDetail2);
        blockDetailDto.setTxdetails(txDetails);
        return blockDetailDto;
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
