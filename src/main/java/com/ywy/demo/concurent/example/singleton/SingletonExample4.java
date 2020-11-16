package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;

/**
 * 懒汉模式->双重同步锁单例模式
 * 线程安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadNotSafe public class SingletonExample4 {
    private static SingletonExample4 instance = null;

    /*
    1.memory = allocate() 分配对象的内存空间
    2.ctorInstance()初始化对象
    3. instance = memory设置instance指向刚分配的内存
     */

    /*
    JVM和cpu优化,发生了指令重排
    1.memory = allocate() 分配对象的内存空间
    3. instance = memory设置instance指向刚分配的内存
    2.ctorInstance()初始化对象
     */

    private SingletonExample4() {

    }

    public static SingletonExample4 getInstance() {
        if (instance == null) { // 线程B 发现已经指针已经指向了某个地址,直接返回了
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();//线程A->步骤3
                }
            }
        }
        return instance;
    }
}
