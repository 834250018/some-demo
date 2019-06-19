package com.ywy.demo;

/**
 * @author ve
 * @date 2019/6/19 15:59
 */
public class UserBuilder {

    private User user = new User();

    UserBuilder userName(String name) {
        user.setName(name);
        return this;
    }

    UserBuilder userAge(int age) {
        user.setAge(age);
        return this;
    }

    User getUser() {
        if (user.getAge() == 0) {
            throw new RuntimeException("没有年龄");
        }
        if (user.getName() == null || user.getName() == "") {
            throw new RuntimeException("没有姓名");
        }
        return user;
    }
}