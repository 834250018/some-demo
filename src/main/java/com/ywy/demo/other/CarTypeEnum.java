package com.ywy.demo.other;

/**
 * @author ve
 * @date 2019/7/3 17:17
 */
public enum CarTypeEnum {
    TYPE1() {
        @Override
        // 如果需要线程安全必须加入synchronized
        synchronized void exec(String label) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(label);
            }
        }
    };

    abstract void exec(String label);
}
