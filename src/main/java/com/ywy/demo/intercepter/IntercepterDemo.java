package com.ywy.demo.intercepter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author ve
 * @date 2019/9/29 18:02
 */
@Slf4j public class IntercepterDemo {

    @Test public void test()
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        log.info("使用代理,实现拦截器功能:");
        IStudent student = (IStudent)Proxy
            .newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IStudent.class},
                new InvProxy1(new Student()));
        student.study();

        // 上面一行代码相当于下面几行代码,但前者多一些访问权限的校验
        Class proxyClzz = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), IStudent.class);
        Constructor cons = proxyClzz.getConstructor(InvocationHandler.class);
        IStudent s2 = (IStudent)cons.newInstance(new InvProxy1(new Student()));
        s2.study();
        log.info("");
    }

    @Test public void test1() throws IOException {
        log.info("输出字节码,反编译");
        FileOutputStream fos = new FileOutputStream("d://StudentProxy.class");
        fos.write(ProxyGenerator.generateProxyClass("$Proxy0", new Class[] {IStudent.class}));
        log.info("");
    }

    @Test public void test2() {
        log.info("多层嵌套代理:");
        IStudent student1 = (IStudent)Proxy
            .newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IStudent.class},
                new InvProxy2(new Student()));
        IStudent student2 = (IStudent)Proxy
            .newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IStudent.class},
                new InvProxy2(student1));
        student2.study();
    }

    /**
     * 模拟交团费
     */
    @Test public void test4() {
        // 创建一个学生名叫小白
        Student student = new Student();
        student.setName("小白");
        // 申请成为团员
        IStudent 小白团费代理_团支书 = (IStudent)Proxy
            .newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IStudent.class}, new 团支书(student));
        // 封装代理第二层
        IStudent 全团团费代理_团长 = (IStudent)Proxy
            .newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IStudent.class}, new 团组织(小白团费代理_团支书));
        // 小白缴纳团费
        全团团费代理_团长.tourFeePay(500);
    }

}
