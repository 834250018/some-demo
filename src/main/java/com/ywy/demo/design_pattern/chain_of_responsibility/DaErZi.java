package com.ywy.demo.design_pattern.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象血缘关系
 *
 * @author ve
 * @date 2019/9/19 16:09
 */
@Slf4j
public class DaErZi extends AbstrackBloodRelationship {

    DaErZi(int money) {
        super(money);
    }

    @Override
    protected void takeMoney() {
        log.info("大儿子掏出了钱");
    }

    @Override
    protected void noMoney() {
        log.info("大儿子掏不出钱");
    }
}
