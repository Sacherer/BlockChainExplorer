package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BlockDetailDto;
import com.example.demo.vo.TxDetail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/blockChain")
public class BlockChainController {
    @RequestMapping("/blockByHash/{blockChainId}/{blockHash}")
    public BlockDetailDto blockByHash(@PathVariable String blockHash,@PathVariable String blockChainId){
        BlockDetailDto blockDetailDto = new BlockDetailDto();
        blockDetailDto.setTxhash("c2b30b0516135b0d0b9b646c3b3b9c66425e86bb1cee773e119eed56030967a6");
        blockDetailDto.setBlockchainId(1);
        blockDetailDto.setBlockhash("00000000000000000018a65ff0bbbc2a93493c693d052d65c6a8dcbb881f55fb");
        blockDetailDto.setDifficulty((double)2);
        blockDetailDto.setFees(0.8);
        blockDetailDto.setHeight(580770);
        blockDetailDto.setMerkleRoot("5207117cb3ef0635be556974a3c781e17905c0e2d4360aec212b5f6a1110e32b");
        blockDetailDto.setMiner("SlushPoo1l");
        blockDetailDto.setNextBlockhash("00000000000000000025c889729b9f97cb3fc683742601fd61c7e481a7e2c951");
        blockDetailDto.setOutputTotal(1647.4593939);
        blockDetailDto.setPrevBlockhash("00000000000000000006a0173f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        blockDetailDto.setTime(new Date());
        blockDetailDto.setTimestamp(new Date());
        blockDetailDto.setTransactions(28671);
        blockDetailDto.setSize((long)1225462);
        blockDetailDto.setTxtime(new Date());
        ArrayList<TxDetail> txDetails = new ArrayList<>();
        TxDetail txDetail = new TxDetail();
        txDetail.setAddress("1CK6KHY6MAg1vmRQ4PAafKYDrg1ejbH1cE ");
        txDetail.setType((byte)2);
        txDetail.setAmount((double)2);
        txDetails.add(txDetail);
        TxDetail txDetail2 = new TxDetail();
        txDetail2.setAddress("1CK6KHY6MHgYvmRQ4PAafKYDrg1ejbH1cE ");
        txDetail2.setType((byte)1);
        txDetail2.setAmount((double)1);
        txDetails.add(txDetail2);
        blockDetailDto.setTxdetails(txDetails);
        return blockDetailDto;
    }
    @RequestMapping("/blockByAddress/{blockChainId}/{Address}")
    public AddressDto getAddress(@PathVariable String Address,@PathVariable String blockChainId){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress("1Ma2DrB78K7jmAwaomqZNRMCvgQrNjE2QC");
        addressDto.setFinalBalance(0.0);
        addressDto.setNoTxSize(107);
        addressDto.setTotalReceived(0.65650635);
        addressDto.setTxhash("12ba70fe122e4e17411100dc349692bf25eeb1222c837b85b93f5a2f358a6197");
        ArrayList<TxDetail> txDetails = new ArrayList<>();
        TxDetail txDetail = new TxDetail();
        txDetail.setAddress("1CK6KHY6MAg1vmRQ4P1afKYDrg1ejbH1cE ");
        txDetail.setType((byte)1);
        txDetail.setAmount((double)3);
        txDetails.add(txDetail);
        TxDetail txDetail2 = new TxDetail();
        txDetail2.setAddress("1CK6KHY6MHgY1mRQ4PAafKYDrg1ejbH1cE ");
        txDetail2.setType((byte)2);
        txDetail2.setAmount((double)1);
        txDetails.add(txDetail2);
        addressDto.setTxdetails(txDetails);
        return addressDto;
    }
}
