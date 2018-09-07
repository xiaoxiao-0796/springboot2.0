package com.xiaofei.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.*;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午2:38 2018/9/7
 **/
@Configuration
@EnableStateMachine
@Slf4j
public class StateMachineConfig extends StateMachineConfigurerAdapter<State,Event>{

    /**
     * 当前的状态机指定了状态监听器
     * @param config
     * @throws Exception
     */
//    public void configure(StateMachineConfigurationConfigurer<State, Event> config) throws Exception {
//        config.withConfiguration()
//                .listener(listener());
//    }
//
//    @Bean
//    public StateMachineListener<State,Event> listener() {
//        return new StateMachineListenerAdapter<State,Event>() {
//            @Override
//            public void transition(Transition<State, Event> transition) {
//                if (transition.getTarget().getId() == State.UNPAID){
//                    log.info("订单新创建,待支付");
//                    return;
//                }
//                if (transition.getSource().getId() == State.UNPAID
//                    && transition.getTarget().getId() == State.WAITING_FOR_RECEIVE){
//                    log.info("订单已支付,待收货");
//                    return;
//                }
//                if (transition.getSource().getId() == State.WAITING_FOR_RECEIVE
//                        && transition.getTarget().getId() == State.DONE){
//                    log.info("订单已完成");
//                    return;
//                }
//            }
//        };
//    }

    /**
     * 初始化当前状态机拥有哪些状态
     * @param states
     * @throws Exception
     */
    public void configure(StateMachineStateConfigurer<State, Event> states) throws Exception {
        states.withStates()
                .initial(State.UNPAID)
                .states(EnumSet.allOf(State.class));
    }

    /**
     * 初始化当前状态机有哪些状态迁移动作
     * @param transitions
     * @throws Exception
     */
    public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
        transitions
                .withExternal()
                .source(State.UNPAID).target(State.WAITING_FOR_RECEIVE)// 指定状态来源和目标
                .event(Event.PAY)	// 指定触发事件
                .and()
                .withExternal()
                .source(State.WAITING_FOR_RECEIVE).target(State.DONE)
                .event(Event.RECEIVE);    }
}
