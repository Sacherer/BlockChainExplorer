package com.example.demo.vo;

import java.util.List;

public class Txs {
    private String txhash;

    private Long txtime;

    private List<TxDetail> txdetails;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Long getTxtime() {
        return txtime;
    }

    public void setTxtime(Long txtime) {
        this.txtime = txtime;
    }

    public List<TxDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TxDetail> txdetails) {
        this.txdetails = txdetails;
    }
}
