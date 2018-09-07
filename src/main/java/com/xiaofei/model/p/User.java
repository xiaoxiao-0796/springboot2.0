package com.xiaofei.model.p;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 下午2:30 2018/9/4
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_test_user")
@Component
public class User implements Serializable{


    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "password")
    private String password;
}
