package com.example.demo.dto;

import com.example.demo.po.Block;
import com.example.demo.po.TransactionDetail;
import com.example.demo.vo.TxDetail;

import java.util.Date;
import java.util.List;

public class BlockDetailDto extends Block {
    private String txhash;
    private Date txtime;
    private List<TxDetail> txdetails;

    public List<TxDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TxDetail> txdetails) {
        this.txdetails = txdetails;
    }

    public Date getTxtime() {
        return txtime;
    }

    public void setTxtime(Date txtime) {
        this.txtime = txtime;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }


}
