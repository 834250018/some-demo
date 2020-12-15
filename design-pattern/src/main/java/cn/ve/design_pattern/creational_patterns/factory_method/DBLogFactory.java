package cn.ve.design_pattern.creational_patterns.factory_method;

/**
 * @author ve
 * @date 2020/4/30 22:56
 */
public class DBLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        return new DBLog();
    }
}
