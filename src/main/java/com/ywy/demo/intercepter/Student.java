package com.ywy.demo.intercepter;

/**
 * @author ve
 * @date 2019/9/29 18:02
 */
public class Student implements IStudent {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void study() {
        System.out.println("学习中....");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void tourFeePay(int money) {
        System.out.println(getName() + "老实地交了" + money + "块钱");
    }
}
