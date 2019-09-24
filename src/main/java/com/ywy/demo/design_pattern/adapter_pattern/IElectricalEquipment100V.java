package com.ywy.demo.design_pattern.adapter_pattern;

/**
 * @author ve
 * @date 2019/9/24 17:41
 */
public interface IElectricalEquipment100V extends IElectricalEquipment {
    default int get额定功率() {
        return 100;
    }
}
