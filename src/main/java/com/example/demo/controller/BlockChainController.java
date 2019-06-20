package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.TransactionSearchDto;
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

        return blockDetailDto;
    }
    @RequestMapping("/blockByAddress/{blockChainId}/{Address}")
    public AddressDto getAddress(@PathVariable String Address,@PathVariable String blockChainId){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress("1Ma2DrB78K7jmAwaomqZNRMCvgQrNjE2QC");
        addressDto.setFinalBalance(0.0);
        addressDto.setNoTxSize(107);
        addressDto.setConfirm(11);
        addressDto.setTime(new Date().getTime());
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
    @RequestMapping("/blockByTxhash/{blockChainId}/{Txhash}")
    public TransactionSearchDto getTransaction(@PathVariable String Txhash, @PathVariable String blockChainId){
        TransactionSearchDto transactionSearchDto = new TransactionSearchDto();

        return transactionSearchDto;
    }
}
