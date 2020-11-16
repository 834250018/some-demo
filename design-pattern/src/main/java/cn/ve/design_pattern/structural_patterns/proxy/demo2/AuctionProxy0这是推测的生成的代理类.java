package cn.ve.design_pattern.structural_patterns.proxy.demo2;

import java.lang.reflect.InvocationHandler;

/**
 * 动态代理,遍历所有接口的所有方法,然后生成一个代理类.java,然后动态编译成代理类.class
 *
 * @author ve
 * @date 2019/7/11 13:24
 */
public class AuctionProxy0这是推测的生成的代理类 implements Auction {

    // 这里的invocationHandler是生成完代理类后,通过代理类的构造函数传入的
    private InvocationHandler invocationHandler;

    public void doSomething() {
        try {
            // 这里可以很轻松地拿到方法名,参数列表及类型
            // 因为整个代理类的生成跟动态编译,都是受控的
            invocationHandler.invoke(this, Auction.class.getMethod("doSomething", (Class<?>)null), null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
