package com.ywy.demo.design_pattern.chain_of_responsibility;

/**
 * 抽象血缘关系
 *
 * @author ve
 * @date 2019/9/19 16:09
 */
public class XiaoErZi extends AbstrackBloodRelationship {

    XiaoErZi(int level) {
        super(level);
    }

    @Override
    protected void takeMoney() {
        System.out.println("小儿子掏出了钱");
    }

    @Override
    protected void noMoney() {
        System.out.println("小儿子掏不出钱");
    }
}
