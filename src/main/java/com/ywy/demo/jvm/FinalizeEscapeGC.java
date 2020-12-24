package com.ywy.demo.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * 重写了finalize,会被执行一次,可以进行自救,第二次回收不会执行finalize(建议大家忘了这个方法)
 *
 * @author 83425
 * @date 2020/12/17
 */
@Slf4j
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public static void main(String[] args) throws InterruptedException {
        // 初始化
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null; // 解除引用
        System.gc(); // 触发gc
        Thread.sleep(1000L); // 因为finalize优先级低,需要等待
        askForResponse();

        // 与上面代码完全相同
        SAVE_HOOK = null; // 解除引用
        System.gc(); // 触发gc
        Thread.sleep(1000L); // 因为finalize优先级低,需要等待
        askForResponse();
        
    }

    private static void askForResponse() {
        if (SAVE_HOOK != null) {
            SAVE_HOOK.answer();
        } else {
            System.out.println("object dead");
        }
    }

    private void answer() {
        System.out.println("i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("exec finalize");
        SAVE_HOOK = this; // 自救
    }
}
