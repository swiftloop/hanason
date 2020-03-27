package com.framework.hanason.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author sorata 2020-03-19 14:03
 */
@Service
public class AsyncTestService {



    @Async
    public void name(){
        for (int i = 0; i < 10; i++) {
            System.out.println("A" +i);
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
