package com.ywy.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * java.lang.DeapOutOfMemoryErrorDemo: Java heap space
 * Dumping heap to java_pid10360.hprof ...
 * Heap dump file created [34006238 bytes in 0.299 secs]
 * Exception in thread "main" java.lang.DeapOutOfMemoryErrorDemo: Java heap space
 * <p>
 * 分两种情况,
 * 一,内存泄漏,通过引用链定位创建位置,进而找到内存泄漏的代码,修复代码
 * 二,内存溢出,
 * 1.检查堆参数-Xmx与-Xms,与机器内存对比,看看是否还有上调空间
 * 2.代码上检查是否存在某些对象生命周期过长,持有状态时间过长,存储结构设计不合理等情况,尽量减少程序运行期的内存消耗
 *
 * @author ve
 * @date 2020/4/19 16:58
 */
public class DeapOutOfMemoryErrorDemo {
    static class OOMObject {

    }

    static List<OOMObject> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            list.add(new OOMObject());
        }
    }
}
