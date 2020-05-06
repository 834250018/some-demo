package com.ywy.demo.equals;

import com.ywy.demo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/6/19 23:20
 */
@Slf4j
public class StringTest {
    public static void main(String[] args) {
        String str = "aaa";
        log.info("执行方法之前的str:" + str); // aaa
        // 字符串地址传递,基本数据类型才是值传递
        changeStr(str);
        log.info("执行方法之后的str:" + str); // aaa

        String str1 = "aaab".replace("b", "");
        log.info("{}", str == str1); // false
        log.info("{}", str.equals(str1)); // true
        User user = new User();
        user.setName("aaa");
        log.info("{}", str == user.getName()); // true
    }

    static void changeStr(String str) {
        str = "bbb"; // 指向新地址,不影响源地址,相当于str = new String("bbb");
    }
}
