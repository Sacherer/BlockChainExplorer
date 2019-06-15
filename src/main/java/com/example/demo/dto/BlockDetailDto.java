package com.example.demo.dto;

import com.example.demo.po.Block;
import com.example.demo.po.TransactionDetail;

import java.util.List;

public class BlockDetailDto extends Block {
    private String txhash;
    private List<TransactionDetail> txdetails;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public List<TransactionDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TransactionDetail> txdetails) {
        this.txdetails = txdetails;
    }
}
