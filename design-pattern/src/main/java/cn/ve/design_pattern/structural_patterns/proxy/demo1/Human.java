package cn.ve.design_pattern.structural_patterns.proxy.demo1;

/**
 * 动态代理模式
 *
 * @author ve
 * @date 2019/7/11 13:17
 */
public class Human implements Auction {

    @Override public void doSomething() {
        System.out.println("eating");
    }

}
