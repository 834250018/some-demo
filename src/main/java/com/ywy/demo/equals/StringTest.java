package com.ywy.demo.equals;

import com.ywy.demo.User;
import lombok.extern.slf4j.Slf4j;

/**
 * java里面只有值传递,没有引用传递
 * 分两种类型,基本数据类型,非基本数据类型
 * 基本数据类型传递的是值的拷贝
 * 非基本数据类型传递的是地址的拷贝,即创建一个新的地址,也指向外面的对象
 *
 * @author ve
 * @date 2019/6/19 23:20
 */
@Slf4j public class StringTest {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str);
        changeStr(str);
        System.out.println(str);

        int a = 1;
        System.out.println(a);
        changeInt(a);
        System.out.println(a);

        User user = new User();
        user.setName("old");
        System.out.println(user.getName());
        changeRef(user);
        System.out.println(user.getName());
        changeProperty(user);
        System.out.println(user.getName());
    }

    static void changeStr(String str) {
        str = "afddd";
    }

    static void changeInt(int str) {
        str = 123;
    }

    static void changeRef(User user) {
        user = null; // 修改引用,值传递,所以对方法体外面引用不产生影响
    }

    static void changeProperty(User user) {
        user.setName("new"); // 这种校验方法是错的,因为是同一个地址,所以方法体外面的属性被修改了,其实引用没有修改
    }
}
