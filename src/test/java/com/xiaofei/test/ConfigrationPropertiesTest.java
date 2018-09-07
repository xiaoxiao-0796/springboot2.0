package com.xiaofei.test;

import com.xiaofei.model.p.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午10:46 2018/9/6
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConfigrationPropertiesTest {


    @Autowired
    private User user;

    @Test
    public void test(){
        System.out.println(user.getAge());
    }
}
