package com.ywy.demo.other;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ve
 * @date 2019/7/3 17:17
 */
@Slf4j public enum CarTypeEnum {
    TYPE1() {
        @Override
        // 如果需要线程安全必须加入synchronized
        synchronized void exec(String label) {
            for (int i = 0; i < 1000; i++) {
                log.info(label);
            }
        }
    };

    abstract void exec(String label);
}
