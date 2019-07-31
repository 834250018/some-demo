package com.ywy.demo.equals;

import com.ywy.demo.design_pattern.builder_pattern.User;

/**
 * @author ve
 * @date 2019/6/19 23:20
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println("执行方法之前的str:" + str); // aaa
        // 字符串地址传递,基本数据类型才是值传递
        changeStr(str);
        System.out.println("执行方法之后的str:" + str); // aaa

        String str1 = "aaab".replace("b", "");
        System.out.println(str == str1); // false
        System.out.println(str.equals(str1)); // true
        User user = new User();
        user.setName("aaa");
        System.out.println(str == user.getName()); // true
    }

    static void changeStr(String str) {
        str = "bbb"; // 指向新地址,不影响源地址,相当于str = new String("bbb");
    }
}
