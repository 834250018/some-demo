package com.ywy.demo.design_pattern.chain_of_responsibility;

/**
 * 责任链模式
 * 老王有两个儿子,小儿子勤快,大儿子有钱
 * 材米油盐这些琐事但是花钱数额较少的都是小儿子负责,电器或者生病,要花大价钱的事情,都是二儿子负责
 *
 * @author ve
 * @date 2019/9/19 16:10
 */
public class ChainOfResponsibilityDemo {


    static AbstrackBloodRelationship 老王不花钱责任链() {
        AbstrackBloodRelationship 大儿子 = new DaErZi(500000000);
        AbstrackBloodRelationship 小儿子 = new XiaoErZi(5000);

// 一般都是小儿子出,小儿子顶不住了旧大儿子出钱
        小儿子.setNextRelationship(大儿子);
        // 所以形成了一条责任链
        return 小儿子;
    }

    public static void main(String[] args) {
        AbstrackBloodRelationship 老王 = 老王不花钱责任链();
        // 老王开始疯狂购物
        老王.cost(30, "买了条内裤");
        老王.cost(5, "买了条袜子");
        老王.cost(500, "买了条CK内裤");
        老王.cost(4000, "买了台ps5");
        老王.cost(100000, "住院了");

    }


}
