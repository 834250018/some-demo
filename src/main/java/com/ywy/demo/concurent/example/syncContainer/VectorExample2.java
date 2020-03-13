package com.ywy.demo.concurent.example.syncContainer;

import com.ywy.demo.concurent.annotations.ThreadNotSafe;

import java.util.Vector;

/**
 * @author ve
 * @date 2020/3/13 12:01
 */
@ThreadNotSafe
public class VectorExample2 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发请求数
    public static int threadTotal = 200;

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            }).start();
        }
    }

}
