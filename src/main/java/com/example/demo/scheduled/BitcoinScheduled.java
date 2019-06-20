package com.example.demo.scheduled;

import com.example.demo.service.BitconinSyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduled {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitconinSyncService bitconinSyncService;

    @Scheduled(fixedRate = 60*1000)
    public void setScheduled(){
        logger.info("the scheduled is start");
//        bitconinSyncService.syncBlockChain("0000000000006a5381c351bce21af5a8889641869e07fdce754b850f5919765e");

    }
}
