package com.ywy.demo;

import java.util.Comparator;

/**
 * @author ve
 * @date 2020/5/6
 */
public class User {
    private static final Comparator<User> COMPARATOR = Comparator.comparing(User::getAge) // 第一次一定要指定类型
            .thenComparing(user -> user.getName()) // 不需要指定类型
            .thenComparing((User user) -> user.getName()); // 同上,展开的写法
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
