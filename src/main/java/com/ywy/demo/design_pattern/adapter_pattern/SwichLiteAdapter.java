package com.ywy.demo.design_pattern.adapter_pattern;

/**
 * 日版switchLite电源适配器
 *
 * @author ve
 * @date 2019/9/24 17:52
 */
public class SwichLiteAdapter implements IElectricalEquipment220V {

    private SwitchLite switchLite;

    @Override
    public String get电器名称() {
        return "(插上适配器的)"+switchLite.get电器名称();
    }
    public SwichLiteAdapter(SwitchLite switchLite) {
        this.switchLite = switchLite;
    }
}
