package cn.ve.design_pattern.behavioral_patterns.strategy.demo2;

/**
 * @author ve
 * @date 2020/5/1 21:51
 */
public class Add implements Strategy {
    @Override public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
