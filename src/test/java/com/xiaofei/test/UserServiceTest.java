package com.xiaofei.test;

import com.xiaofei.model.p.User;
import com.xiaofei.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午9:53 2018/9/7
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test1(){
        userService.insert(new User("4","大汉口",32,"8765"));

        User user1 = userService.getById("4");
        System.out.println("第一次查询"+user1);
        User user2 = userService.getById("4");
        System.out.println("第二次查询"+user2);

        userService.updateById(new User("4","差点迟到",32,"345678"));
        User user3 = userService.getById("4");
        System.out.println("第三次查询"+user3);
    }
}
