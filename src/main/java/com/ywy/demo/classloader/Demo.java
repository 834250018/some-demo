package com.ywy.demo.classloader;

/**
 * @author ve
 * @date 2020/5/22
 */
public class Demo {
    public static void main(String[] args) {
        // 需要指定父加载器为extClassLoader
        MyClassLoader myClassLoader = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.ywy.demo.User", true, myClassLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }
}
