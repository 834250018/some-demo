package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * -XX:PermSize=6M -XX:MaxPermSize=6M (在jdk6有效)
 * jdk7及以上版本的常量池被移到堆中,会产生不同的效果
 * jdk6: OutOfMemoryError: PermGen space
 * jdk7,8: OutOfMemoryError: Java heap space (限制堆大小的情况下会出现)
 * jdk6中运行时常量池在方法区,jdk7及以上在堆内
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class MetaRoom {
    public static void main(String[] args) {
//        String::intern(); // 此方法返回常量池内此字符串的引用,若未找到,则先将字符串放入常量池,再返回引用
        short i = 0; // short范围内足以让6mb的PermSize产生OOM
        Set<String> set = new HashSet<>(); // 维持引用,不让回收
        while (true) {
            set.add(String.valueOf(i).intern());
        }
    }
}
