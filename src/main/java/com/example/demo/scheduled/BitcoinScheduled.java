package com.example.demo.scheduled;

import com.example.demo.service.BitconinSyncService;
import com.example.demo.service.TransationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduled {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitconinSyncService bitconinSyncService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private TransationService transationService;

    @Value("${bitcoin.sync.startHash}")
    private String blockHash;

    @Scheduled(cron = "${bitcoin.sync.cron}")
    public void setScheduled(){
        logger.info("the scheduled is start");
        bitconinSyncService.syncBlockChain(blockHash);
    }
    @Scheduled(cron = "${bitcoin.txIndex.cron}")
    public void txIndex(){
//        logger.info("begin to send data {}",transationService.getTxIndex());
        simpMessagingTemplate.convertAndSend("/topic/txIndex",transationService.getTxIndex());
    }
    @Scheduled(cron = "${bitcoin.txMore.cron}")
    public void txMore(){
//        logger.info("begin to send data {}",transationService.getMoreTx());
        simpMessagingTemplate.convertAndSend("/topic/txMore",transationService.getMoreTx());
    }
}
