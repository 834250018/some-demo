package cn.ve.designpattern.behavioral_patterns.StatePattern;

/**
 * @author ve
 * @date 2020/5/2 13:28
 */
public class RichState implements State {
    @Override
    public void costAllMoney(AMan aMan) {
        System.out.println("富人花光了所有钱");
        aMan.setState(AMan.poolState);
    }

    @Override
    public void costLittleMoney(AMan aMan) {
        System.out.println("富人花了一笔小钱");
    }

    @Override
    public void earnLostOfMoney(AMan aMan) {
        System.out.println("富人赚了很多很多的钱");
    }

    @Override
    public void earnLittleMoney(AMan aMan) {
        System.out.println("富人赚了点钱");
    }
}
