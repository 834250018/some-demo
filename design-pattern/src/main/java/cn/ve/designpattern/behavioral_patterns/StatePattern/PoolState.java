package cn.ve.designpattern.behavioral_patterns.StatePattern;

/**
 * @author ve
 * @date 2020/5/2 13:28
 */
public class PoolState implements State {
    @Override
    public void costAllMoney(AMan aMan) {
        System.out.println("穷人花光了所有钱");
    }

    @Override
    public void costLittleMoney(AMan aMan) {
        System.out.println("穷人花了一笔小钱");
    }

    @Override
    public void earnLostOfMoney(AMan aMan) {
        System.out.println("穷人赚了很多很多的钱");
        aMan.setState(AMan.richState);
    }

    @Override
    public void earnLittleMoney(AMan aMan) {
        System.out.println("穷人赚了点钱");
    }
}
