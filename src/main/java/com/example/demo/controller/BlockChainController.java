package com.example.demo.controller;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.TransactionSearchDto;
import com.example.demo.po.Block;
import com.example.demo.service.BlockService;
import com.example.demo.service.TransationService;
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


    @RequestMapping("/blockByAddress/{blockchainId}/{Address}")
    public AddressDto getAddress(@PathVariable String Address,@PathVariable Integer blockchainId){
        AddressDto addressDto =transationService.getAddress(Address);

        return addressDto;
    }

    @RequestMapping("/search/{blockchainId}/{param}")
    public Object getSearch(@PathVariable String param, @PathVariable Integer blockchainId){
        AddressDto addressDto =transationService.getAddress(param);
        if(addressDto!=null){
            return addressDto;
        }else{
            String reg="^\\d+$";
            if(param.matches(reg)){
                Block block = blockService.searchBlockByHeight(Integer.parseInt(param), blockchainId);
                if(block!=null){
                    return block;
                }
            }else{
                if(param.length()==64){
                    BlockDetailDto blockDetailDto = blockService.searchBlockByHash(param,blockchainId);
                    if(blockDetailDto!=null){
                        return blockDetailDto;
                    }else{
                        TransactionSearchDto transactionSearchDto = transationService.seaerchTransactionByTxhash(param,blockchainId);
                        if(transactionSearchDto!=null){
                            return  transactionSearchDto;
                        }
                    }
                }
            }
        }
        return null;
    }
}
