package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.*;

/**
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class ReferenceDemo {

    static ReferenceQueue<Object> q = new ReferenceQueue<>(); // 虚引用队列

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                Reference<?> poll = q.poll();
                if (poll != null) {
                    System.out.println(poll); // 虚引用对象的回收通知
                    break;
                }
            }
        }).start();

        Object o = new Object(); // 强引用,只要存在就不会回收
        SoftReference<Object> softReference = new SoftReference<>(new Object()); // 软引用,在系统将要内存溢出前,会纳入回收范围进入第二次回收,第二次回收还没有足够的内存,再抛出内存溢出
        WeakReference<Object> weakReference = new WeakReference<>(new Object()); // 弱引用,只能活到下一次垃圾回收
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), q); // 虚引用(幽灵引用/幻影引用),唯一目的是在对象被回收的时候收到一个系统通知,没有其他功能
        System.gc();


    }
}
