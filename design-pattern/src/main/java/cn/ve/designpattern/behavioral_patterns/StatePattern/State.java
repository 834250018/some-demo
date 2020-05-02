package cn.ve.designpattern.behavioral_patterns.StatePattern;

/**
 * @author ve
 * @date 2020/5/2 12:49
 */
public interface State {
    void costAllMoney(AMan aMan);

    void costLittleMoney(AMan aMan);

    void earnLostOfMoney(AMan aMan);

    void earnLittleMoney(AMan aMan);
}
