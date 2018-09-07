package com.xiaofei.test;

import com.xiaofei.statemachine.Event;
import com.xiaofei.statemachine.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午2:56 2018/9/7
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StateMachineTest {

    @Autowired
    private StateMachine<State,Event> stateMachine;

    @Test
    public void test1(){
        stateMachine.start();

        stateMachine.sendEvent(Event.PAY);

        stateMachine.sendEvent(Event.RECEIVE);
    }
}
