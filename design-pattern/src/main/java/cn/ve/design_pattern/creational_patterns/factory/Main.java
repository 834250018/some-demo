package cn.ve.design_pattern.creational_patterns.factory;

/**
 * @author ve
 * @date 2020/4/30 22:59
 */
public class Main {
    public static void main(String[] args) {
        // 文件日志工厂创建文件日志
        FileLog fileLog = (FileLog)new FileLogFactory().createLog();
        // 数据库日志工厂创建数据库日志
        DBLog dbLog = (DBLog)new DBLogFactory().createLog();
        fileLog.printLog();
        dbLog.printLog();
    }
}
