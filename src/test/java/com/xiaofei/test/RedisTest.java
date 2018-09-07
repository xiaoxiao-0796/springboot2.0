package com.xiaofei.test;

import com.xiaofei.model.p.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午2:07 2018/9/6
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void test1(){
        User user = new User();
        user.setId("3");
        user.setName("test3");
        user.setAge(22);
        user.setPassword("9876543");
        redisTemplate.opsForValue().set(user.getId(),user);

        User user1 = redisTemplate.opsForValue().get("3");
        System.out.println(user1);
    }

    @Test
    public void test2(){
        User user = redisTemplate.opsForValue().get("2");
        System.out.println(user);
    }

}
