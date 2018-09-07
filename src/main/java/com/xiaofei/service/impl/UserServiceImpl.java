package com.xiaofei.service.impl;

import com.xiaofei.model.p.User;
import com.xiaofei.model.p.UserRepository;
import com.xiaofei.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午10:42 2018/9/5
 **/
@Service
@CacheConfig(cacheNames = "users")
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    @Cacheable(key = "#p0")
    public User getById(String id) {
        log.info("通过ID查询用户信息");
        return userRepository.findById(id).get();
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    @CacheEvict(key = "#p0.id")
    public void updateById(User user) {
        userRepository.saveAndFlush(user);
    }
}
