package cn.ve.designpattern.creational_patterns.FactoryPattern;

/**
 * @author ve
 * @date 2020/4/30 22:58
 */
public class FileLog implements Log {
    public void printLog() {
        System.out.println("file log");
    }
}
