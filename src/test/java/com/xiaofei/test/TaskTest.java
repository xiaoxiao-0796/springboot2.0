package com.xiaofei.test;

import com.xiaofei.task.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午3:38 2018/9/6
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void test1() throws InterruptedException {
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
    }
}
