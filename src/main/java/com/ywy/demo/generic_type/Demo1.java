package com.ywy.demo.generic_type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ve
 * @date 2020/5/14
 */
public class Demo1 {
    public static void main(String[] args) {
//        List list = new ArrayList();// 不建议使用原生态类型
        List<String> list = new ArrayList(); // ArrayList后面没有尖括号,非受检警告
        List<String> list1 = new ArrayList<>(); // 建议使用泛型,保证类型安全性,编译时发现类型异常

        unsafeAdd(list, 12);

//        String str = list.get(0); // ClassCastException
//        Integer i = list.get(0); // can`t compiler

//        unsafeAdd2(list, 12); // can`t compiler 泛型可以传入原生态类型,但是不能向上转型

        Set<String> set1 = new HashSet<>();
        set1.add("abc");
        Set<Integer> set2 = new HashSet<>();
        set2.add(123);
        mergeSet(set1, set2);
        count(set1, set2);
//        mergeSet2(set1, set2); // can`t compiler

        //
        /* 上界与下界的区别,PECS即(producer-extends与consumer-super),生产者时使用上界通配符,消费者使用下界通配符
        Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
        //不能存入任何元素
        p.set(new Fruit()); //Error
        p.set(new Apple()); //Error
        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1=p.get();
        Object newFruit2=p.get();
        Apple newFruit3=p.get(); //Error

        Plate<? super Fruit> p=new Plate<Fruit>(new Fruit());
        //存入元素正常
        p.set(new Fruit());
        p.set(new Apple());
        //读取出来的东西只能存放在Object类里。
        Apple newFruit3=p.get(); //Error
        Fruit newFruit1=p.get(); //Error
        Object newFruit2=p.get();
         */
    }

    static void unsafeAdd(List list, Object o) {
        list.add(o); // 非受检警告,不安全
    }

    static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }

    static void canNotAdd(List<? extends String> list, Object o) {
//        list.add(o); // can`t compiler
//        list.add(null); // add null was ok
//        list.add("dsf"); // can`t compiler
        list.get(0); // 警告
    }

    static void canNotGet(List<? super String> list, Object o) {
        list.add("ff");
//        String aa = list.get(0); // can`t convert
        Object bb = list.get(0);
    }

    static Set mergeSet(Set set1, Set set2) { // 如果不设置泛型,不安全
        set1.addAll(set2); // 不安全,非受检警告
        return set1;
    }

    static <E> Set<E> mergeSet2(Set<E> set1, Set<E> set2) { // 统一泛型
        set1.addAll(set2);
        return set1;
    }

    static int count(Set<?> set1, Set<?> set2) { // 无限制泛型
        return set1.size() + set2.size();
    }
}
