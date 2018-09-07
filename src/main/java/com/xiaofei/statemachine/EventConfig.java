package com.xiaofei.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @Description：状态机注解监听器
 * @Ahthor: xiaofei
 * @Date: Create in 下午3:07 2018/9/7
 **/
@WithStateMachine
@Slf4j
public class EventConfig {

    @OnTransition(target = "UNPAID")
    public void create(){
        log.info("订单新创建,待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        log.info("用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.info("用户已收货，订单完成");
    }


}
