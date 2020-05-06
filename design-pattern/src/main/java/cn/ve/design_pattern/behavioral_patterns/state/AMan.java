package cn.ve.design_pattern.behavioral_patterns.state;

/**
 * @author ve
 * @date 2020/5/2 13:16
 */
public class AMan implements State {
    public static PoolState poolState = new PoolState();
    public static RichState richState = new RichState();
    private State state = poolState; // 初始状态是穷人

    public State getState() {
        return state;
    }

    public void setState(State state) {
        System.out.println("此人的状态发生了改变,新身份为: " + ((state instanceof PoolState) ? "穷人" : "富人"));
        this.state = state;
    }

    /**
     * 从语境来说,下面这几个方法都不需要入参,我这里这样写是贪快,后续要调整
     * @param aMan
     */
    @Override
    public void costAllMoney(AMan aMan) {
        state.costAllMoney(this);
    }

    @Override
    public void costLittleMoney(AMan aMan) {
        state.costLittleMoney(this);
    }

    @Override
    public void earnLostOfMoney(AMan aMan) {
        state.earnLostOfMoney(this);
    }

    @Override
    public void earnLittleMoney(AMan aMan) {
        state.earnLittleMoney(this);
    }
}
