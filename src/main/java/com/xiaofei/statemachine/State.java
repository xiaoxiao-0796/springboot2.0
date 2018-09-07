package com.xiaofei.statemachine;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午2:35 2018/9/7
 **/
public enum State {

    UNPAID,  //待支付

    WAITING_FOR_RECEIVE,    // 待收货

    DONE; //完成
}
