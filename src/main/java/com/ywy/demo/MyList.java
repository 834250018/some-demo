package com.ywy.demo;

/**
 * @author 83425
 * @date 2020/11/29
 */
public interface MyList<V> {
    boolean isEmpty();

    boolean contains(V value);

    void clear();

    int size();

    void add(V value);

    V get(int index);

    V remove(int index);
}
