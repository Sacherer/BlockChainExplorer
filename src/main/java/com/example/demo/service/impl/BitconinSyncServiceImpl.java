package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
import com.example.demo.enumeration.TransactionDetailType;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.mapper.TransactionDetailMapper;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.po.Block;
import com.example.demo.po.Transaction;
import com.example.demo.po.TransactionDetail;
import com.example.demo.service.BitconinSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
@EnableAutoConfiguration
public class BitconinSyncServiceImpl implements BitconinSyncService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlockChainApi blockChainApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Override
    public void syncBlockChain(String blockHash) {
        String tempHash = "";
        JSONObject chinInfo = blockChainApi.getChinInfo();
        Integer newHeight = chinInfo.getInteger("blocks");
        Block block = blockMapper.selectByPrimaryKey(blockHash);
        if (block != null) {
            Integer endHeight = blockMapper.selectByEnd();
            if (!endHeight.equals(newHeight)) {
                JSONObject blockhashByHeight = blockChainApi.getBlockhashByHeight(endHeight + 1);
                tempHash = blockhashByHeight.getString("blockhash");
            }
        } else {
            tempHash = blockHash;
        }
        if (!tempHash.isEmpty()) {
            logger.info("start sync block data the hash is {}", tempHash);
        }
        while (tempHash != null && !tempHash.isEmpty()) {
            String nextBlockhash = syncBlockData(tempHash);
            tempHash = nextBlockhash;
        }
        logger.info("end sync block data");
    }

    @Override
//    @Async
    @Transactional
    public String syncBlockData(String tempHash) {
        JSONObject blocks = blockChainApi.getBlocks(tempHash);
        Block block1 = new Block();
        block1.setBlockchainId(1);
        block1.setBlockhash(blocks.getString("hash"));
        block1.setDifficulty(blocks.getDouble("difficulty"));
        //todo set blockfee
        block1.setFees(null);
        block1.setHeight(blocks.getInteger("height"));
        block1.setMerkleRoot(blocks.getString("merkleroot"));
        //todo set miner
        block1.setMiner(null);
        block1.setNextBlockhash(blocks.getString("nextblockhash"));
        block1.setPrevBlockhash(blocks.getString("previousblockhash"));
        block1.setSize(blocks.getLong("size"));
        Long time = blocks.getLong("time");
        block1.setTime(new Date(time * 1000));
        block1.setTimestamp(new Date(time * 1000));
        block1.setTransactions(blocks.getInteger("nTx"));
        //todo

        JSONArray tx = blocks.getJSONArray("tx");
        for (Object o : tx) {
            JSONObject txObject = new JSONObject((LinkedHashMap) o);
            syncTx(blocks, txObject);
        }
        block1.setOutputTotal(getBlockOutputTotal(blocks.getString("hash")));
        blockMapper.insert(block1);
        return  block1.getNextBlockhash();
    }

    @Override
    @Transactional
    public void syncTx(JSONObject blocks, JSONObject txObject) {
        Transaction transaction = new Transaction();
        transaction.setBlockhash(blocks.getString("hash"));
        transaction.setConfirm(blocks.getInteger("confirmations"));
        //todo set txfree
        transaction.setFees(null);
        transaction.setSize(txObject.getLong("size"));
        Long time = blocks.getLong("time");
        transaction.setTime(new Date(1000 * time));
        String txid = txObject.getString("txid");
        transaction.setTxhash(txid);
        transaction.setWeight(txObject.getInteger("weight"));

        syncTxDetail(txid,txObject);
        transaction.setTotalInput(getTxTotalInput(txid));
        transaction.setTotalOutput(getTxTotalOutput(txid));
        transactionMapper.insert(transaction);
    }

    @Override
    public void syncTxDetail(String txid, JSONObject txObject) {
        JSONArray vin = txObject.getJSONArray("vin");
        JSONArray vout = txObject.getJSONArray("vout");
        for (Object ovin : vin) {
            JSONObject vinObject = new JSONObject(((LinkedHashMap) ovin));
            vint(txid, vinObject);
        }
        for (Object ovout : vout) {
            JSONObject voutObject = new JSONObject(((LinkedHashMap) ovout));
            vout(txid, voutObject);
        }
    }

    @Override
    public Double getTxTotalInput(String txid) {
        Double totalInput=transactionDetailMapper.getTxTotalInput(txid);
        return totalInput;
    }

    @Override
    public Double getTxTotalOutput(String txid) {
        Double totalOutput=transactionDetailMapper.getTxTotalOutput(txid);
        return totalOutput;
    }

    @Override
    public Double getBlockOutputTotal(String blockhash) {
        Double blockOutputTotal=transactionMapper.getBlockOutputTotal(blockhash);
        return blockOutputTotal;
    }

    @Override
    @Transactional
    public void vout(String txid, JSONObject voutObject) {
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTxid(txid);
        transactionDetail.setAmount(voutObject.getDouble("value"));
        transactionDetail.setType((byte) TransactionDetailType.Receive.ordinal());
        JSONObject scriptPubKey = voutObject.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        if (addresses != null ) {
            String addressStr = addresses.getString(0);
            transactionDetail.setAddress(addressStr);
        }
        transactionDetailMapper.insert(transactionDetail);
    }

    @Override
    @Transactional
    public void vint(String txid, JSONObject vinObject) {
        String vinTxid = vinObject.getString("txid");
        Integer n = vinObject.getInteger("vout");
        if(vinTxid!=null){
            JSONObject vinTxjson = blockChainApi.getTransactions(vinTxid);
            JSONArray vouts = vinTxjson.getJSONArray("vout");
            JSONObject utxoJson = vouts.getJSONObject(n);
            TransactionDetail transactionDetail = new TransactionDetail();
            transactionDetail.setType((byte) TransactionDetailType.Send.ordinal());
            transactionDetail.setAmount(-utxoJson.getDouble("value"));
            transactionDetail.setTxid(txid);
            JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            if (addresses != null ) {
                String addressStr = addresses.getString(0);
                transactionDetail.setAddress(addressStr);
            }
            transactionDetailMapper.insert(transactionDetail);
        }

    }


}
