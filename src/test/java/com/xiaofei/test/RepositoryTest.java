package com.xiaofei.test;

import com.xiaofei.model.p.User;
import com.xiaofei.model.p.UserRepository;
import com.xiaofei.model.s.Student;
import com.xiaofei.model.s.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午9:16 2018/9/6
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void test1(){
        userRepository.save(new User("2","回答苦",21,"987654"));
    }

    @Test
    public void test2(){
        studentRepository.save(new Student("2","蛋壳",21));
    }

    @Test
    public void test3(){
        userRepository.save(new User("3","唐山市",33,"0987654"));
        Optional<User> user = userRepository.findById("1");
        System.out.println("第一次查询:"+user.get().getName());
        Optional<User> user1 = userRepository.findById("1");
        System.out.println("第二次查询:"+user1.get().getName());
    }

}
