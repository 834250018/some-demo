package cn.ve.design_pattern.behavioral_patterns.strategy.demo2;

/**
 * @author ve
 * @date 2020/5/1 21:53
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
