package cn.ve.designpattern.structural_patterns.ProxyPattern.demo2;

/**
 * 动态代理模式
 *
 * @author ve
 * @date 2019/7/11 13:17
 */
public class Human implements Auction {

    @Override
    public void doSomething() {
        System.out.println("eating");
    }

}
