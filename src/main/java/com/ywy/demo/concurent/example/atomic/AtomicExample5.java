package com.ywy.demo.concurent.example.atomic;

import com.ywy.demo.concurent.annotations.ThreadSafe;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ve
 * @date 2020/3/12 20:04
 */
@ThreadSafe
public class AtomicExample5 {

    // 原子性更新某个类的某个字段
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");
    private static AtomicExample5 example5 = new AtomicExample5();
    // 必须要有volatile且不能用static修饰
    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success{}" + example5.getCount());
        }
        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success{}" + example5.getCount());
        } else {
            System.out.println("update failed{}" + example5.getCount());
        }
    }
}
