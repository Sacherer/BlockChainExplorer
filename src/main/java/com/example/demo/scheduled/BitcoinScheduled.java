package com.example.demo.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduled {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 10*60*1000)
    public void setScheduled(){
        logger.info("the scheduled is start");
    }
}
