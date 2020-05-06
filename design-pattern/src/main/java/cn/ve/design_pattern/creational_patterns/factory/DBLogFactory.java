package cn.ve.design_pattern.creational_patterns.factory;

/**
 * @author ve
 * @date 2020/4/30 22:56
 */
public class DBLogFactory extends LogFactory {
    Log createLog() {
        return new DBLog();
    }
}
