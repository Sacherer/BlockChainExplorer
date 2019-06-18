package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.BlockChainApi;
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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
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
    @Async
    @Transactional
    public void syncBlockData(String blockHash) {

        String tempHash="";
        JSONObject chinInfo = blockChainApi.getChinInfo();
        Integer newHeight=chinInfo.getInteger("blocks");
        Block block = blockMapper.selectByPrimaryKey(blockHash);
        if(block!=null){
            Integer endHeight= blockMapper.selectByEnd();
            if(!endHeight.equals(newHeight)){
                JSONObject blockhashByHeight = blockChainApi.getBlockhashByHeight(endHeight+1);
                tempHash=blockhashByHeight.getString("blockhash");
            }
        }else{
            tempHash=blockHash;
        }
        if(!tempHash.isEmpty()){
            logger.info("start sync block data the hash is {}",tempHash);
        }
        while (tempHash != null && !tempHash.isEmpty()){
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
            block1.setTime(new Date(time*1000));
            block1.setTimestamp(new Date(time*1000));
            block1.setTransactions(blocks.getInteger("nTx"));
            //todo
            block1.setOutputTotal(null);
            blockMapper.insert(block1);
            JSONArray tx = blocks.getJSONArray("tx");
            for (Object o : tx) {
                JSONObject txObject = new JSONObject((LinkedHashMap)o);
                syncTx(blocks,txObject);
            }
            tempHash=block1.getNextBlockhash();
        }
        logger.info("end sync block data");
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
        transaction.setTime(new Date(1000*time));
        transaction.setTxhash(txObject.getString("txid"));
        transaction.setWeight(txObject.getInteger("weight"));
        //todo set totalinput
        transaction.setTotalInput(null);
        //todo set totaloutput
        transaction.setTotalOutput(null);
        transactionMapper.insert(transaction);
        String txid = txObject.getString("txid");
        JSONArray vin = txObject.getJSONArray("vin");
        JSONArray vout = txObject.getJSONArray("vout");
        for (Object ovin : vin) {
            JSONObject vinObject = new JSONObject(((LinkedHashMap)ovin));
            vint(txid,vinObject);
        }
        for (Object ovout : vout) {
            JSONObject voutObject = new JSONObject(((LinkedHashMap)ovout));
            vout(txid,voutObject);
        }
    }

    @Override
    public void vout(String txid, JSONObject voutObject) {
        TransactionDetail transactionDetail = new TransactionDetail();
        transactionDetail.setTxid(txid);
        transactionDetail.setAmount(voutObject.getDouble("value"));
        transactionDetail.setType((byte)1);
//        JSONObject scriptPubKey = voutObject.getJSONObject("scriptPubKey");
//        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
//        if(addresses!=null&&!addresses.isEmpty()){
//            String addressStr = addresses.getString(0);
//            transactionDetail.setAddress(addressStr);
//        }
        transactionDetail.setAddress(voutObject.getJSONObject("scriptPubKey").getString("addresses"));
        transactionDetailMapper.insert(transactionDetail);
    }

    @Override
    public void vint(String txid, JSONObject vinObject) {

    }

}
