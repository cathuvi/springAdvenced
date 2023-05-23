package com.cathuvi.springadvenced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {


    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();

        strategy.call();
        long endTiem = System.currentTimeMillis();
        long resultTime = endTiem - startTime;
        log.info("resultTime={}",resultTime);
    }

}
