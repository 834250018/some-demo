package com.ywy.demo;

/**
 * 简单工厂
 * @author ve
 * @date 2019/6/19 16:51
 */
public class PetStore {
    public static Animal getAnimal(String name) {
        if("cat".equals(name)) {
            return new Cat();
        } else if("dog".equals(name)) {
            return new Dog();
        } else {
            throw new NullPointerException();
        }
    }
}
