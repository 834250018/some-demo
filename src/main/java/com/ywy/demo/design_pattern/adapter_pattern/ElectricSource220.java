package com.ywy.demo.design_pattern.adapter_pattern;

/**
 * 电源
 *
 * @author ve
 * @date 2019/9/24 17:29
 */
public class ElectricSource220 {

    /**
     * 插上用电器
     *
     * @param electricalEquipment
     */
    public static void append220(IElectricalEquipment220V electricalEquipment) {
        System.out.println(electricalEquipment.get电器名称() + "正常使用");
    }

}
