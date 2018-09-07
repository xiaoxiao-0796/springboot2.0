package com.xiaofei.exception;

import lombok.Data;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午10:22 2018/9/5
 **/
@Data
public class ErrorInfo<T> {

    private String code;

    private String msg;

    private boolean success;

    private T data;
}
