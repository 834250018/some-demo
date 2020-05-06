package cn.ve.design_pattern.structural_patterns.adapter.demo1;

/**
 * @author ve
 * @date 2020/5/1 23:04
 */
public class ElectricSource implements ThreePinSocket {
    @Override
    public void powerSupply(ThreePinPlug threePinPlug) {
        System.out.println("电源正在给三针插头的设备供电中");
        threePinPlug.supply();
    }
}
