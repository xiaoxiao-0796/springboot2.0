package com.xiaofei.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description：全局异常处理
 * @Ahthor: xiaofei
 * @Date: Create in 上午9:45 2018/9/5
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ErrorInfo jsonErrorHandler(RuntimeException e){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setCode("500");
        errorInfo.setMsg(e.getMessage());
        errorInfo.setSuccess(false);
        return errorInfo;
    }
}
