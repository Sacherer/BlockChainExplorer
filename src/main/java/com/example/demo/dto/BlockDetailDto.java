package com.example.demo.dto;

import com.example.demo.vo.Txs;

import java.util.List;

public class BlockDetailDto {
    private String blockhash;

    private Integer blockchainId;

    private Integer height;

    private Long time;

    private Integer transactions;

    private Long size;

    private Double difficulty;

    private String prevBlockhash;

    private String nextBlockhash;

    private Double outputTotal;

    private Double fees;

    private String merkleRoot;

    private String miner;

    private Long timestamp;

    private List<Txs> txs;

    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    public Integer getBlockchainId() {
        return blockchainId;
    }

    public void setBlockchainId(Integer blockchainId) {
        this.blockchainId = blockchainId;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getTransactions() {
        return transactions;
    }

    public void setTransactions(Integer transactions) {
        this.transactions = transactions;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getPrevBlockhash() {
        return prevBlockhash;
    }

    public void setPrevBlockhash(String prevBlockhash) {
        this.prevBlockhash = prevBlockhash;
    }

    public String getNextBlockhash() {
        return nextBlockhash;
    }

    public void setNextBlockhash(String nextBlockhash) {
        this.nextBlockhash = nextBlockhash;
    }

    public Double getOutputTotal() {
        return outputTotal;
    }

    public void setOutputTotal(Double outputTotal) {
        this.outputTotal = outputTotal;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Txs> getTxs() {
        return txs;
    }

    public void setTxs(List<Txs> txs) {
        this.txs = txs;
    }
}
