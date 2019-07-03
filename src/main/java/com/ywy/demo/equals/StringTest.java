package com.ywy.demo.equals;

import com.ywy.demo.pattern.User;

/**
 * @author ve
 * @date 2019/6/19 23:20
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "aaa";
        // 字符串值传递
        changeStr(str);
        System.out.println(str); // aaa

        String str1 = "aaab".replace("b", "");
        System.out.println(str == str1); // false
        System.out.println(str.equals(str1)); // true
        User user = new User();
        user.setName("aaa");
        System.out.println(str == user.getName()); // true
    }

    static void changeStr(String str) {
        str = "bbb";
    }
}
