package com.cathuvi.springadvenced.trace.threadlocal;

import com.cathuvi.springadvenced.trace.threadlocal.code.FiledService;
import com.cathuvi.springadvenced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private FiledService filedService = new FiledService();

    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = () ->{
            filedService.logic("userA");
        };

        Runnable userB = () ->{
            filedService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 발생X
        sleep(100); //동시성 문제 발생
        threadB.start();

        sleep(3000); //메인 쓰레드 종료 대기
        log.info("main exit");

    }

    @Test
    void threadLocal(){
        log.info("main start");
        Runnable userA = () ->{
            threadLocalService.logic("userA");
        };

        Runnable userB = () ->{
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
//        sleep(2000); //동시성 문제 발생X
        sleep(100); //동시성 문제 발생
        threadB.start();

        sleep(3000); //메인 쓰레드 종료 대기
        log.info("main exit");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
