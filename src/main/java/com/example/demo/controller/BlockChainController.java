package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.TransactionSearchDto;
import com.example.demo.service.BlockService;
import com.example.demo.service.TransationService;
import com.example.demo.vo.TxDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/blockChain")
public class BlockChainController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private TransationService transationService;

    @RequestMapping("/blockByHash/{blockchainId}/{blockhash}")
    public BlockDetailDto blockByHash(@PathVariable String blockhash,@PathVariable Integer blockchainId){
        BlockDetailDto blockDetailDto = blockService.searchBlockByHash(blockhash,blockchainId);
        return blockDetailDto;
    }
    @RequestMapping("/blockByAddress/{blockchainId}/{Address}")
    public AddressDto getAddress(@PathVariable String Address,@PathVariable Integer blockchainId){
        AddressDto addressDto =transationService.getAddress(Address,blockchainId);

        return addressDto;
    }
    @RequestMapping("/blockByTxhash/{blockchainId}/{Txhash}")
    public TransactionSearchDto getTransaction(@PathVariable String Txhash, @PathVariable Integer blockchainId){
        TransactionSearchDto transactionSearchDto = transationService.seaerchTransactionByTxhash(Txhash,blockchainId);

        return transactionSearchDto;
    }
}
