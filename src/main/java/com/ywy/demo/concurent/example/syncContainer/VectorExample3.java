package com.ywy.demo.concurent.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author ve
 * @date 2020/3/13 12:01
 */
@Slf4j
public class VectorExample3 {

    private static Vector<Integer> vector = new Vector<>();

    private static void test1(Vector<Integer> v1) {
        for (Integer integer : v1) {
            if (integer.equals(3)) {
                v1.remove(integer);
            }
        }
    }

    private static void test2(Vector<Integer> v1) {
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3) || i.equals(4)) {
                iterator.remove(); // right result
//                v1.remove(i); // ConcurrentModificationException
            }
        }
        log.info("" + v1);
    }

    private static void test3(Vector<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3) || v1.get(i).equals(4)) {
                v1.remove(i);
            }
        }
        log.info("" + v1);
    }

    public static void main(String[] args) throws Exception {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
//        test1(vector); // ConcurrentModificationException
        test2(vector); // right result or ConcurrentModificationException
//        test3(vector); // error result
    }

}
