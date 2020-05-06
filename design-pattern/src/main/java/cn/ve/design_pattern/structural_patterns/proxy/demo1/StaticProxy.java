package cn.ve.design_pattern.structural_patterns.proxy.demo1;

/**
 * @author ve
 * @date 2019/7/11 13:16
 */
public class StaticProxy implements Auction {

    public Human human;

    public StaticProxy(Human human) {
        this.human = human;
    }

    @Override
    public void doSomething() {
        System.out.println("静态代理");
        human.doSomething();
    }
}
