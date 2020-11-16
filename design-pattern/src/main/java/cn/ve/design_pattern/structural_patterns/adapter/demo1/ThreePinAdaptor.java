package cn.ve.design_pattern.structural_patterns.adapter.demo1;

/**
 * 适配器,可以插入三针插座的电源获取电能,然后给两针插头的电器进行供电
 *
 * @author ve
 * @date 2020/5/1 13:52
 */
public class ThreePinAdaptor implements ThreePinPlug, TwoPinSocket {

    public boolean powerStatus = false; // 为了更形象,增加一个电源通电状态,当插入电源时,则通电

    @Override public void powerSupply(TwoPinPlug twoPinPlug) {
        if (powerStatus) {
            System.out.println("适配器正在给两针插头的设备供电");
        } else {
            System.out.println("适配器未通电,无法给两针插头的设备供电");
        }
    }

    @Override public void supply() {
        this.powerStatus = true;
    }
}
