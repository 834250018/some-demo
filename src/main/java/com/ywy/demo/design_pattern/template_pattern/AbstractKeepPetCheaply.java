package com.ywy.demo.design_pattern.template_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 平民养宠物
 *
 * @author ve
 * @date 2019/9/19 10:53
 */
@Slf4j
public class AbstractKeepPetCheaply extends AbstractKeepPet {
    @Override
    public void selectPet() {
        log.info("我这么懒,养只猫吧");
    }

    @Override
    public void getPet() {
        log.info("没钱买品种猫,路边抓一只野猫");
    }

    @Override
    public void petNamed() {
        log.info("整天miaomiao叫的,就叫miumiu吧");
    }

    @Override
    public void feedPet() {
        log.info("巅峰猫粮太贵了,喂主食罐头也太贵了,还是喂皇家猫粮吧");
    }

    @Override
    public void wishPet() {
        log.info("宠物店洗澡要100大洋,我还是自己给他洗吧");
    }
}
