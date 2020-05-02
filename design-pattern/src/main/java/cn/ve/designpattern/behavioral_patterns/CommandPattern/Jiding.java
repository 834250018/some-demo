package cn.ve.designpattern.behavioral_patterns.CommandPattern;

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
