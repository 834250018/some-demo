package cn.ve.designpattern.creational_patterns.FactoryPattern;

/**
 * @author ve
 * @date 2020/4/30 22:56
 */
public class FileLogFactory extends LogFactory {
    Log createLog() {
        return new FileLog();
    }
}
