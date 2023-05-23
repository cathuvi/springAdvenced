package com.cathuvi.springadvenced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        long startTime = System.currentTimeMillis();

        strategy.call();;
        long endTiem = System.currentTimeMillis();
        long resultTime = endTiem - startTime;
        log.info("resultTime={}",resultTime);
    }
}
