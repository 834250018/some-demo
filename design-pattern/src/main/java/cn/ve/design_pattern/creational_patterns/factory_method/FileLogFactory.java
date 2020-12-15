package cn.ve.design_pattern.creational_patterns.factory_method;

/**
 * @author ve
 * @date 2020/4/30 22:56
 */
public class FileLogFactory implements LogFactory {
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
