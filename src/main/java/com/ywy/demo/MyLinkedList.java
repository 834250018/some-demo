package com.ywy.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * @author 83425
 * @date 2020/11/29
 */
@Slf4j
public class MyLinkedList<V> implements MyList<V>, Iterable<V> {

    private Node<V> first;
    private Node<V> last;
    private int size;

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(new AA(), "1");
        objectObjectHashMap.put(new AA(), "2");
        objectObjectHashMap.put(new AA(), "3");
        objectObjectHashMap.put(new AA(), "4");
        objectObjectHashMap.put(new AA(), "5");
        objectObjectHashMap.put(new AA(), "6");
        objectObjectHashMap.put(new AA(), "7");
        objectObjectHashMap.put(new AA(), "8");
        objectObjectHashMap.put(new AA(), "9"); // 扩容一次 32
        objectObjectHashMap.put(new AA(), "0"); // 扩容一次 64
//        objectObjectHashMap.put(new AA(), "11");  // 转红黑树
//        objectObjectHashMap.put(new AA(), "12");
//        .put(new AA(), "a");
        System.out.println();
    }

    public static class AA {
        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(V value) {
        Node<V> firstNode = first;
        while (firstNode != null) {
            if (first.value.equals(value)) {
                return true;
            }
            firstNode = firstNode.next;
        }
        return false;
    }

    @Override
    public void add(V value) {
        size++;
        Node<V> objectNode = new Node<>();
        objectNode.setValue(value);

        if (first == null) {
            first = objectNode;
            last = objectNode;
            return;
        }
        objectNode.setPrevious(last);
        last.setNext(objectNode);
        last = objectNode;

    }

    @Override
    public V get(int index) throws IndexOutOfBoundsException {
        rangeCheck(index);
        Node<V> result;
        if (index <= (size >> 1)) {
            result = first;
            for (int i = 0; i <= index; i++) {
                result = result.next;
            }
        } else {
            result = last;
            for (int i = size - 1; i >= index; i--) {
                result = result.previous;
            }
        }
        return result.getValue();
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public V remove(int index) throws IndexOutOfBoundsException {
        rangeCheck(index);
        Node<V> result;
        if (index <= (size >> 1)) {
            result = first;
            for (int i = 0; i <= index; i++) {
                result = result.next;
            }
        } else {
            result = last;
            for (int i = size - 1; i >= index; i--) {
                result = result.previous;
            }
        }
        size--;
        if (result.previous == null && result.next == null) {
            result.previous = null;
            result.next = null;
        } else if (result.previous == null) {
            first = result.next;
            first.previous = null;
        } else if (result.next == null) {
            last = result.previous;
            last.next = null;
        }
        return result.value;
    }

    @Data
    class Node<V> {
        Node<V> previous;
        Node<V> next;
        V value;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index;

            @Override
            public boolean hasNext() {
                return index < size - 1;
            }

            @Override
            public Object next() {
                return get(index++);
            }
        };
    }
}
