package cn.ve.design_pattern.behavioral_patterns.command;

/**
 * @author ve
 * @date 2020/5/2 18:05
 */
public class Jiding implements Command {

    private Paoding2 paoding2 = new Paoding2();

    @Override
    public void call() {
        paoding2.action();
    }
}
