package com.xiaofei.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午3:07 2018/9/4
 **/
@RestController
public class HelloController {

    @ApiOperation(value = "web测试")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return "HELLO WORLD";
    }
}
