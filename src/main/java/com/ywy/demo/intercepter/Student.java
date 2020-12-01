package com.ywy.demo.intercepter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/9/29 18:02
 */
@Slf4j
public class Student implements IStudent {
    private String name;

    public void study() {
        log.info("学习中....");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void tourFeePay(int money) {
        log.info(getName() + "老实地交了" + money + "块钱");
    }
}
