package com.example.demo.dto;

import com.example.demo.vo.Txs;

import java.util.List;

public class AddressDto {
    private String address;
    private Double totalReceived;
    private Double finalBalance;
    private Integer txSize;

    private List<Txs> txs;

    public List<Txs> getTxs() {
        return txs;
    }

    public void setTxs(List<Txs> txs) {
        this.txs = txs;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(Double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public Double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(Double finalBalance) {
        this.finalBalance = finalBalance;
    }


    public Integer getTxSize() {
        return txSize;
    }

    public void setTxSize(Integer txSize) {
        this.txSize = txSize;
    }


}
