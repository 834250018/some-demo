package cn.ve.design_pattern.creational_patterns.factory_method;

/**
 * @author ve
 * @date 2020/4/30 22:59
 */
public class Main {
    public static void main(String[] args) {
        // 文件日志工厂创建文件日志
        LogFactory fileLogFactory = new FileLogFactory();
        // 数据库日志工厂创建数据库日志
        LogFactory dbLogFactory = new DBLogFactory();

        // 生产产品
        Log fileLog = fileLogFactory.createLog();
        Log dbLog = dbLogFactory.createLog();

        // 使用产品
        fileLog.printLog();
        dbLog.printLog();
    }
}
