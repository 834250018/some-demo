package com.ywy.demo.design_pattern.adapter_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 电源
 *
 * @author ve
 * @date 2019/9/24 17:29
 */
@Slf4j
public class ElectricSource220 {

    /**
     * 插上用电器
     *
     * @param electricalEquipment
     */
    public static void append220(IElectricalEquipment220V electricalEquipment) {
        log.info(electricalEquipment.get电器名称() + "正常使用");
    }

}
