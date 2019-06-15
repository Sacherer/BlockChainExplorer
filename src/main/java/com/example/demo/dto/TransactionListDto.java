package com.example.demo.dto;

import com.example.demo.po.TransactionDetail;

import java.util.Date;
import java.util.List;

public class TransactionListDto {
    private String txhash;

    private String blockhash;

    private Long size;

    private Integer weight;

    private Date time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Integer confirm;

    private List<TransactionDetail> txdetails;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(Double totalInput) {
        this.totalInput = totalInput;
    }

    public Double getTotalOutput() {
        return totalOutput;
    }

    public void setTotalOutput(Double totalOutput) {
        this.totalOutput = totalOutput;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public Integer getConfirm() {
        return confirm;
    }

    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    public List<TransactionDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TransactionDetail> txdetails) {
        this.txdetails = txdetails;
    }
}
