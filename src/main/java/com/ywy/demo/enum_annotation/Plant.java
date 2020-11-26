package com.ywy.demo.enum_annotation;

/**
 * @author ve
 * @date 2020/5/15
 */
public class Plant {
    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString() {
        return name;
    }

    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}
}
