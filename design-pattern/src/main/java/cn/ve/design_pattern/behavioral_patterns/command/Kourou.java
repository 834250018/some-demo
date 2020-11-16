package cn.ve.design_pattern.behavioral_patterns.command;

/**
 * @author ve
 * @date 2020/5/2 18:05
 */
public class Kourou implements Command {

    private Paoding1 paoding1 = new Paoding1();

    @Override public void call() {
        paoding1.action();
    }
}
