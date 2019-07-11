package com.ywy.demo.design_pattern.builder_pattern;

import com.ywy.demo.design_pattern.builder_pattern.User;
import com.ywy.demo.design_pattern.builder_pattern.UserBuilder;

/**
 * 建造者模式BuilderPattern
 *
 * @author ve
 * @date 2019/6/19 15:34
 */
public class Test {

    public static void main(String[] args) {
        // 建造者模式
        User zhangsan = new UserBuilder().userAge(25).userName("张三").getUser();
        User lisi = new UserBuilder().userAge(22).userName("李四").getUser();
        User wangwu = new UserBuilder().userAge(60).userName("王五").getUser();

        // 原型模式(不允许对旧数据进行操作,则创建一个副本)
        User wangwu1 = wangwu.clone();
        System.out.println();
    }

}
