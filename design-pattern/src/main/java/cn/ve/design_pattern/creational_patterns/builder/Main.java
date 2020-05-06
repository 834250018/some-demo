package cn.ve.design_pattern.creational_patterns.builder;

/**
 * 建造者模式,内置一个builder类通过链式调用的方式赋值并生成User对象
 *
 * @author ve
 * @date 2020/4/30 22:21
 */
public class Main {
    public static void main(String[] args) {
        User.builder().age(15).name("小明").build();
    }
}
