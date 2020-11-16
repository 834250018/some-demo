package cn.ve.design_pattern.structural_patterns.decorator.demo2;

import java.util.Collection;
import java.util.HashSet;

/**
 * 通过继承来实现额外的功能,往往不能正常工作,因为继承的功能是基于父类现有的实现进行操作,但是不能保证父类在下一个版本中的实现不被改变
 *
 * @author ve
 * @date 2020/5/9
 */
public class MyErrorHashSet extends HashSet {

    private int addCount = 0; // 计算

    public int getAddCount() {
        return addCount;
    }

    @Override public boolean add(Object o) {
        addCount++;
        return super.add(o);
    }

    @Override public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    // 删除的同上,此处省略
}
