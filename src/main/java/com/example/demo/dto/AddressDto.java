package com.example.demo.dto;

import com.example.demo.vo.TxDetail;

import java.util.List;

public class AddressDto {
    private String address;
    private Double totalReceived;
    private Double finalBalance;
    private String txhash;
    private Integer noTxSize;
    private Long time;
    private Integer confirm;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    private List<TxDetail> txdetails;

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

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Integer getNoTxSize() {
        return noTxSize;
    }

    public void setNoTxSize(Integer noTxSize) {
        this.noTxSize = noTxSize;
    }

    public List<TxDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TxDetail> txdetails) {
        this.txdetails = txdetails;
    }
}
