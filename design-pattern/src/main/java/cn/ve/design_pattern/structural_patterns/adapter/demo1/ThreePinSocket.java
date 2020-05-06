package cn.ve.design_pattern.structural_patterns.adapter.demo1;

/**
 * 三针插座,可以给三针插头供电
 *
 * @author ve
 * @date 2020/5/1 13:43
 */
public interface ThreePinSocket {
    void powerSupply(ThreePinPlug threePinPlug);
}
