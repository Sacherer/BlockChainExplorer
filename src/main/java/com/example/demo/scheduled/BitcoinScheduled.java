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
        bitconinSyncService.syncBlockChain("00000000001d7ea79990e760bd01aeb8ca696ef67ec1d1ae5cfd19a1067efc7c");
    }
}
