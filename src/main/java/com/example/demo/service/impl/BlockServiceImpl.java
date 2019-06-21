package com.example.demo.service.impl;

import com.example.demo.dto.BlockDetailDto;
import com.example.demo.dto.BlockIndexDto;
import com.example.demo.mapper.BlockMapper;
import com.example.demo.mapper.TransactionDetailMapper;
import com.example.demo.mapper.TransactionMapper;
import com.example.demo.po.Block;
import com.example.demo.po.Transaction;
import com.example.demo.po.TransactionDetail;
import com.example.demo.service.BlockService;
import com.example.demo.vo.TxDetail;
import com.example.demo.vo.Txs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Override
    public List<BlockIndexDto> getBlockIndex() throws Throwable {
        List<Block> blocks = blockMapper.getBlockIndex();
        List<BlockIndexDto> blockIndexDtos = new ArrayList<>();
        for (Block block : blocks) {
            BlockIndexDto blockIndexDto = new BlockIndexDto();
            blockIndexDto.setTime(block.getTime().getTime());
            blockIndexDto.setMiner(block.getMiner());
            blockIndexDto.setBlockhash(block.getBlockhash());
            blockIndexDto.setHeight(block.getHeight());
            blockIndexDto.setTransactions(block.getTransactions());
            blockIndexDto.setSize(block.getSize());
            blockIndexDtos.add(blockIndexDto);
        }
        return blockIndexDtos;
    }

    @Override
    public Block getBlockByHeight(Integer height) {
        Block block = blockMapper.selectByHeight(height);
        return block;
    }

    @Override
    public BlockDetailDto getBlockByHash(String blockhash) {
        Block block = blockMapper.selectByPrimaryKey(blockhash);
        BlockDetailDto blockDetailDto = getBlockDetail(block);
        return blockDetailDto;
    }

    @Override
    public BlockDetailDto getBlockDetail(Block block) {
        List<Transaction> transaction = transactionMapper.selectByBlockHash(block.getBlockhash());
        BlockDetailDto blockDetailDto = new BlockDetailDto();
        blockDetailDto.setSize(block.getSize());
        blockDetailDto.setTransactions(block.getTransactions());
        blockDetailDto.setPrevBlockhash(block.getPrevBlockhash());
        blockDetailDto.setOutputTotal(block.getOutputTotal());
        blockDetailDto.setNextBlockhash(block.getNextBlockhash());
        blockDetailDto.setMiner(block.getMiner());
        blockDetailDto.setMerkleRoot(block.getMerkleRoot());
        blockDetailDto.setHeight(block.getHeight());
        blockDetailDto.setFees(block.getFees());
        blockDetailDto.setDifficulty(block.getDifficulty());
        blockDetailDto.setBlockhash(block.getBlockhash());
        blockDetailDto.setBlockchainId(block.getBlockchainId());
        blockDetailDto.setTime(block.getTime().getTime());
        blockDetailDto.setTimestamp(block.getTimestamp().getTime());
        ArrayList<Txs> txs = new ArrayList<>();
        for (Transaction transaction1 : transaction) {
            Txs txs1 = getTxs(transaction1);
            txs.add(txs1);
        }
        blockDetailDto.setTxs(txs);
        return blockDetailDto;
    }

    @Override
    public Txs getTxs(Transaction transaction) {
            Txs txs1 = new Txs();
            txs1.setTxhash(transaction.getTxhash());
            txs1.setTxtime(transaction.getTime().getTime());
            List<TransactionDetail> transactionDetails =  transactionDetailMapper.selectByTxId(transaction.getTxhash());
            ArrayList<TxDetail> txDetail = new ArrayList<>();
            for (TransactionDetail transactionDetail : transactionDetails) {
                TxDetail txDetail1 = new TxDetail();
                txDetail1.setAddress(transactionDetail.getAddress());
                txDetail1.setType(transactionDetail.getType());
                txDetail1.setAmount(transactionDetail.getAmount());
                txDetail.add(txDetail1);
            }
            txs1.setTxdetails(txDetail);

        return txs1;
    }

    @Override
    public BlockDetailDto searchBlockByHash(String blockhash, Integer blockchainId) {
        Block block = blockMapper.searchBlockByHash(blockhash,blockchainId);
        if(block!=null){

            BlockDetailDto blockDetail = getBlockDetail(block);
            return blockDetail;
        }
        return null;
    }

    @Override
    public Block searchBlockByHeight(int height, Integer blockchainId) {
        return blockMapper.searchBlockByHeight(height,blockchainId);
    }
}
