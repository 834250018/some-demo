package com.ywy.demo.other;

import lombok.extern.slf4j.Slf4j;

/**
 * 格式为
 * .(类名.java:行号)
 * 这类打印,idea跟eclipse会识别出跳转链接,部分jar包不会
 * 注意左括号前面有至少一个点号,点号与左括号之间可以存在其他字符如.*(StaticBlockTest.java:1)或Test.main(StaticBlockTest.java:1)等等
 *
 * @author ve
 * @date 2019/7/3 16:24
 */
@Slf4j
public class Test1 {

    public static void main(String[] args) {
        // 此demo在StackTraceElement.toString找到,部分jar包加了.点号也不会生成链接,暂时没有找到原因
        log.info("(StackTraceElement.java:171)");

        // idea控制台不会有链接可以点击跳转
        log.info("(Test1.java:18)");
        // 只要有一个.点号,都会生成跳转链接
        log.info("Test1.main(Test1.java:18)");
        System.err.println(".*(SwitchTest.java:18)");
        System.err.println(Thread.currentThread().getStackTrace()[0].toString());
        System.err.println(Thread.currentThread().getStackTrace()[1].toString());
    }
}
