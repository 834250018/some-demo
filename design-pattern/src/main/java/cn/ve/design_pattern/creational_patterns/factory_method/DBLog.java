package cn.ve.design_pattern.creational_patterns.factory_method;

/**
 * @author ve
 * @date 2020/4/30 22:58
 */
public class DBLog implements Log {
    public void printLog() {
        System.out.println("db log");
    }
}
