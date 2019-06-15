package com.example.demo.dto;

import com.example.demo.vo.TxDetail;

import java.util.List;

public class TransactionSearchDto {
    private String txhash;


    private Long size;

    private Integer weight;

    private Long time;

    private Double totalInput;

    private Double totalOutput;

    private Double fees;

    private Integer confirm;

    private List<TxDetail> txdetails;

    private Integer height;

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
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

    public List<TxDetail> getTxdetails() {
        return txdetails;
    }

    public void setTxdetails(List<TxDetail> txdetails) {
        this.txdetails = txdetails;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
