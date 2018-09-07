package com.xiaofei.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午3:26 2018/9/6
 **/
@Component
public class AsyncTask {


    @Async
    public void task1() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        Thread.sleep( new Random().nextInt(7000));
        System.out.println("任务1耗时:"+(System.currentTimeMillis()-timeMillis));
    }

    @Async
    public void task2() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        Thread.sleep( new Random().nextInt(6000));
        System.out.println("任务2耗时:"+(System.currentTimeMillis()-timeMillis));
    }

    @Async
    public void task3() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        Thread.sleep( new Random().nextInt(3000));
        System.out.println("任务3耗时:"+(System.currentTimeMillis()-timeMillis));
    }
}
