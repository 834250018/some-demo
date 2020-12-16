package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:PermSize=10m -XX:MaxPermSize=10m (jdk7) OutOfMemoryError: PermGen space
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m (jdk8)  OutOfMemoryError: Metaspace
 * cglib动态生成大量类,模拟方法区内存溢出
 * 需引入cglib框架依赖
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class PermGenSpaceOutOfMemoryErrorDemo {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }

}
