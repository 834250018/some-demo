package cn.ve.design_pattern.behavioral_patterns.strategy.demo2;

/**
 * 策略模式,通过加载不同的策略对象,执行不同的业务逻辑
 *
 * @author ve
 * @date 2020/5/1 21:03
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context(new Add());
        System.out.println(context.executeStrategy(10, 5));
        context = new Context(new Subtract());
        System.out.println(context.executeStrategy(10, 5));
    }
}
