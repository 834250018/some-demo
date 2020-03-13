package com.ywy.demo.design_pattern.builder_pattern;

import com.ywy.demo.design_pattern.UserTypeEnum;

/**
 * @author ve
 * @date 2019/6/19 15:59
 */
public class User implements Cloneable {
    private int age;
    private String name;
    private UserTypeEnum type;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public UserBuilder UserBuilder() {
        return new UserBuilder();
    }

    /**
     * 重写clone方法,用于原型模式
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public User clone() {
        User user = new User();
        user.setAge(getAge());
        user.setName(getName());
        return user;
    }
}