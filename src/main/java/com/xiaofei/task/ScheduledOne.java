package com.xiaofei.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description：定时任务
 * @Ahthor: xiaofei
 * @Date: Create in 下午3:07 2018/9/6
 **/
@Slf4j
@Component
public class ScheduledOne {

    /**
     * 执行开始后五秒后循环
     */
    @Scheduled(fixedRate=5000)
    public void doScheduledOne(){
        log.info("定时任务开始了,date:{}",new Date());
        System.out.println(new Date());
    }
}
