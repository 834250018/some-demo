package cn.ve.design_pattern.structural_patterns.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理,通过实现InvocationHandler接口
 *
 * @author ve
 * @date 2019/7/11 13:19
 */
public class DynamicProxy implements InvocationHandler {

    Object targetObj;

    public DynamicProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理执行之前:" + method.getName());
        Object result = method.invoke(targetObj, args);
        System.out.println("执行完之后增加业务逻辑");
        return result;
    }
}
