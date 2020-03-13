package com.ywy.demo.guava;

import com.google.common.base.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2020/3/2 18:06
 */
@Slf4j
public class ObjcetDemo {
    public static void main(String[] args) {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        User user = new User(30, "张三");
        log.info("{}", Objects.hashCode(user));
        log.info("{}", Objects.hashCode(user.getAge(), user.getName()));
//        log.info(Objects.toString(user.getAge(),user.getName()));
    }
}
