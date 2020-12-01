package com.ywy.demo.other;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ve
 * @date 2019/7/3 16:24
 */
@Slf4j
public class Test {

    volatile int i = 2;

    public static void main(String[] args) {
        String str = "fff    AAAAA";
        log.info("{}", str.split(" ").length); // 5 // n个连续空格,保留n-1个长度,再加上其他字符串,即5=4-1+2
        log.info("{}", str.split(" +").length); // 2

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");
        arrayList.add("ddd");
        // subList返回类型是ArrayList的内部类SubList,不能转换成ArrayList
        //        ArrayList subList = (ArrayList) arrayList.subList(0, 2); ClassCastException!!
        List<String> subList = arrayList.subList(0, 2);
        subList.set(0, "a+a+a");
        // subList返回结果是原数组的视图,任何操作都会反馈到原数组
        log.info(arrayList.get(0)); // a+a+a

        // Map 的方法 keySet()/values()/entrySet()返回集合对象时，不可以对其进行添 加元素操作
        // Collections 类返回的对象，如：emptyList()/singletonList()等都是immutable list，不可对其进行添加或者删除元素的操作
        // Arrays.asList()同上

    }
}
