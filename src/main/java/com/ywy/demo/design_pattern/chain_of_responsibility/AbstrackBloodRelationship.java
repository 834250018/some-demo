package com.ywy.demo.design_pattern.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象血缘关系
 *
 * @author ve
 * @date 2019/9/19 16:09
 */
@Slf4j
public abstract class AbstrackBloodRelationship {

    // 当前关系肯花钱的上限
    protected int moneyLimit;

    protected AbstrackBloodRelationship nextRelationship;

    AbstrackBloodRelationship(int moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public void setNextRelationship(AbstrackBloodRelationship nextRelationship) {
        this.nextRelationship = nextRelationship;
    }

    public void cost(int money, String remark) {
        log.info(remark + "需要" + money + "元");
        if (money <= this.moneyLimit) {
            takeMoney();
        } else {
            noMoney();
            if (nextRelationship != null) {
                nextRelationship.cost(money, remark);
            }
        }
    }

    protected abstract void takeMoney();

    protected abstract void noMoney();

}
