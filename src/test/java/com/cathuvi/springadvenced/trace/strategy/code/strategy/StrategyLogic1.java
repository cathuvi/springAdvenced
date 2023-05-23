package com.cathuvi.springadvenced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic1 implements Strategy {
    @Override
    public void call() {
      log.info("비니지스 로직1 실행");
    }
}
