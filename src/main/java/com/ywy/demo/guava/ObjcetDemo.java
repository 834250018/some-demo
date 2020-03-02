package com.ywy.demo.guava;

import com.google.common.base.Objects;

/**
 * @author ve
 * @date 2020/3/2 18:06
 */
public class ObjcetDemo {
    public static void main(String[] args) {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        User user = new User(30, "张三");
        System.out.println(Objects.hashCode(user));
        System.out.println(Objects.hashCode(user.getAge(),user.getName()));
//        System.out.println(Objects.toString(user.getAge(),user.getName()));
    }
}
