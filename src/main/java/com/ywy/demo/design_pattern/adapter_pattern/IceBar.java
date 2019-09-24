package com.ywy.demo.design_pattern.adapter_pattern;

/**
 * @author ve
 * @date 2019/9/24 17:49
 */
public class IceBar implements IElectricalEquipment220V {

    @Override
    public String get电器名称() {
        return "美的冰吧kj5200";
    }

}
