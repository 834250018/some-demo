package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * jdk6,运行时常量池在方法区,方法区内的引用(str.intern())跟堆内的引用(str)永远不同(false)
 * jdk7,8,运行时常量池在堆内
 * 在jdk7,8--->"计算机软件"这个字符串是第一次创建,所以StringBuilder::toString()创建的引用等于"计算机软件".intern(),所以true
 * 在jdk7,8--->"java"这个字符串不是第一次创建,所以StringBuilder::toString()是新创建的引用不等于"java".intern(),所以false
 * 补充:字符串"java"是在加载sun.misc.Version这个类的时候进入常量池
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class StringInternDemo {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true,在jdk6的时候是false

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // false
    }
}
