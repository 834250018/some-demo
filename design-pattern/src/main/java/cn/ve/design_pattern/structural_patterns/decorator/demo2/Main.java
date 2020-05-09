package cn.ve.design_pattern.structural_patterns.decorator.demo2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 装饰器模式
 * 比如,对HashSet进行扩展,增加一个计数功能
 * 包装类不使用于回调(callback)框架,在回调框架中,对象把自身引用(this)传递给其他对象,用于后续的回调,所以回调不会走包装类
 *
 * @author ve
 * @date 2020/5/9
 */
public class Main {
    public static void main(String[] args) {
        // 继承,不建议的修饰者
        MyErrorHashSet myErrorHashSet = new MyErrorHashSet();
        myErrorHashSet.addAll(Arrays.asList("a", "b", "c"));
        // 期望结果是3,实际打印是6
        System.out.println(myErrorHashSet.getAddCount());
        // 因为HashSet里面,addAll调用了add方法,所以会统计两次,虽然可以基于这个事实继续修改MyErrorHashSet里面的逻辑,但是不保证HashSet这个事实在下一个版本中还是事实.

        // 复合(转发),面向接口
        MyWrapperHashSet myWrapperHashSet = new MyWrapperHashSet(new HashSet());
        myWrapperHashSet.addAll(Arrays.asList("a", "b", "c"));
        System.out.println(myWrapperHashSet.getAddCount()); // 结果是3

    }
}
