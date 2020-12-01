package com.ywy.demo.concurent.example.singleton;

import com.ywy.demo.concurent.annotations.ThreadSafe;

/**
 * 懒汉模式->双重同步锁单例模式
 * 线程安全
 *
 * @author ve
 * @date 2020/3/12 21:37
 */
@ThreadSafe
public class SingletonExample5 {
    /**
     * 使用volatile+双重检测机制,限制指令重排
     */
    private volatile static SingletonExample5 instance = null;

    /*
    1.memory = allocate() 分配对象的内存空间
    2.ctorInstance()初始化对象
    3. instance = memory设置instance指向刚分配的内存
     */

    private SingletonExample5() {

    }

    public static SingletonExample5 getInstance() {
        if (instance == null) { // 双重检测机制 // B
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();//线程A->步骤3
                }
            }
        }
        return instance;
    }
}
