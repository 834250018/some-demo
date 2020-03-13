package com.ywy.demo.design_pattern.chain_of_responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 抽象血缘关系
 *
 * @author ve
 * @date 2019/9/19 16:09
 */
@Slf4j
public class XiaoErZi extends AbstrackBloodRelationship {

    XiaoErZi(int level) {
        super(level);
    }

    @Override
    protected void takeMoney() {
        log.info("小儿子掏出了钱");
    }

    @Override
    protected void noMoney() {
        log.info("小儿子掏不出钱");
    }
}
