package com.xiaofei.service;

import com.xiaofei.model.p.User;

import java.util.List;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午10:39 2018/9/5
 **/
public interface IUserService {

    List<User> getAll();

    void insert(User user);

    User getById(String id);

    void deleteById(String id);

    void updateById(User user);

}
