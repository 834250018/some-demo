package com.ywy.demo.design_pattern.factory_pattern;

/**
 * 简单工厂
 *
 * @author ve
 * @date 2019/6/19 16:51
 */
public class Test {
    public static Animal getAnimal(String name) {
        if ("cat".equals(name)) {
            return new Cat();
        } else if ("dog".equals(name)) {
            return new Dog();
        } else {
            throw new NullPointerException();
        }
    }

    public static void main(String[] args) {
        // 工厂模式
        Animal cat = Test.getAnimal("cat");
        Animal dog = Test.getAnimal("dog");
    }
}
