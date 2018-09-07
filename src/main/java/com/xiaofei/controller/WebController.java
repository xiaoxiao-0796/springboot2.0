package com.xiaofei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午4:31 2018/9/4
 **/
@Controller
@Slf4j
public class WebController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("hosts","www.baidu.com");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String testException() throws Exception {
        throw new Exception("哦 my god");
    }

    @RequestMapping("/test1")
    public String jsonException() {
        throw new RuntimeException("哦 my god");
    }


    @RequestMapping(value = "/testlog",method = RequestMethod.GET)
    @ResponseBody
    public String logger() {
        log.debug("log---debug");
        log.info("log---info");
        log.warn("log---warn");
        return "";
    }
}
