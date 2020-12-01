package com.ywy.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

/**
 * @author 83425
 * @date 2020/11/29
 */
@Slf4j
public class MyArrayList<V> implements MyList<V>{

    public static void main(String[] args) {
        MyLinkedList<String> objects = new MyLinkedList<>();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        objects.forEach(o -> {
            System.out.println(o);
        });
    }

    private int size;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(V value) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(V value) {

    }

    @Override
    public V get(int index) {
        return null;
    }

    @Override
    public V remove(int index) {
        return null;
    }
}
