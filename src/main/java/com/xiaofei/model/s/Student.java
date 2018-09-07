package com.xiaofei.model.s;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午11:05 2018/9/6
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_test_student")
public class Student {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
