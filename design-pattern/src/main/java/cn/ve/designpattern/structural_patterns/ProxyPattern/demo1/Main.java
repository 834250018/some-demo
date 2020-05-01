package cn.ve.designpattern.structural_patterns.ProxyPattern.demo1;

/**
 * @author ve
 * @date 2020/5/1 19:01
 */
public class Main {
    public static void main(String[] args) {

        Human human = new Human();

        StaticProxy staticProxy = new StaticProxy(new Human());
        staticProxy.doSomething();

    }
}
