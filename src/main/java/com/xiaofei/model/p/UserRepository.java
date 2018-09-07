package com.xiaofei.model.p;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午4:30 2018/9/5
 **/
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findById(String id);

}
