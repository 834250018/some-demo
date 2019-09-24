package com.ywy.demo.design_pattern.adapter_pattern;

/**
 * 适配器模式,用于解决系统旧接口问题,而不是设计系统时使用
 * 举个栗子
 * 我买了个日版的switchLite(新需求)
 * 但是日版的电器额定电压是100V
 * 在国内220V环境我不能直接插在插座上使用(旧接口)
 * 所以我要买一个电源适配器器(适配器模式)
 *
 * @author ve
 * @date 2019/9/24 17:30
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // 创建一个电源
        ElectricSource220 electricSource220 = new ElectricSource220();

        // 旧接口,仅允许使用220V的电器,比如下面这个冰吧
        electricSource220.append220(new IceBar());
        // 新买的switchLite无法使用
//        electricSource220.append220(new SwitchLite()));

        // SwitchLite插上适配器,然后适配器插在电压上
        electricSource220.append220(new SwichLiteAdapter(new SwitchLite()));
    }
}
