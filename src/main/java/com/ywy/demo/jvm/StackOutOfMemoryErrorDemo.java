package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * -Xss2M
 * 在32位系统多线程开发时会出现
 * OutOfMemoryError: unable to create native thread
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class StackOutOfMemoryErrorDemo {

    public static void main(String[] args) {
        // todo 警告,请在32位非windows系统下测试
        // new StackOutOfMemoryErrorDemo().stackLeakByThread();
    }

    private void stackLeakByThread() {
        while (true) { // 不断创建线程
            new Thread(this::dontStop).start();
        }
    }

    private void dontStop() {
        while (true) { // 保持线程运行

        }
    }

}
