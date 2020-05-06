package cn.ve.design_pattern.behavioral_patterns.command;

/**
 * @author ve
 * @date 2020/5/2 18:08
 */
public class Waiter {
    private Kourou m;
    private Jiding l;

    public Kourou getM() {
        m.call();
        return m;
    }

    public void setM(Kourou m) {
        this.m = m;
    }

    public Jiding getL() {
        l.call();
        return l;
    }

    public void setL(Jiding l) {
        this.l = l;
    }
}
