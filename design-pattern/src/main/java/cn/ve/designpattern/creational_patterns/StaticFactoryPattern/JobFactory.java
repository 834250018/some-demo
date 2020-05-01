package cn.ve.designpattern.creational_patterns.StaticFactoryPattern;

/**
 * 通过硬性编码直接比对入参是否符合特定字符串,然后返回具体的工作
 * @author ve
 * @date 2020/4/30 22:46
 */
public enum JobFactory {
    ;

    private Job getJob(String job) {
        if ("Teacher".equals(job)) {
            return new Teacher();
        } else {
            return new Worker();
        }
    }
}
