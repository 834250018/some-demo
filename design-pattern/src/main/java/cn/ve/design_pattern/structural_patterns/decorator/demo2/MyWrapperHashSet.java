package cn.ve.design_pattern.structural_patterns.decorator.demo2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 通过继承来实现额外的功能,往往不能正常工作,因为继承的功能是基于父类现有的实现进行操作,但是不能保证父类在下一个版本中的实现不被改变
 *
 * @author ve
 * @date 2020/5/9
 */
public class MyWrapperHashSet implements Set {

    private int addCount = 0; // 计算
    private Set set;

    public MyWrapperHashSet(Set set) {
        this.set = set;
    }

    public int getAddCount() {
        return addCount;
    }

    @Override public int size() {
        return set.size();
    }

    @Override public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override public Iterator iterator() {
        return set.iterator();
    }

    @Override public Object[] toArray() {
        return set.toArray();
    }

    @Override public boolean add(Object o) {
        addCount++;
        return set.add(o);
    }

    @Override public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override public boolean addAll(Collection c) {
        addCount += c.size();
        return set.addAll(c);
    }

    @Override public void clear() {
        set.clear();
    }

    @Override public boolean removeAll(Collection c) {
        return set.removeAll(c);
    }

    @Override public boolean retainAll(Collection c) {
        return set.retainAll(c);
    }

    @Override public boolean containsAll(Collection c) {
        return set.containsAll(c);
    }

    @Override public Object[] toArray(Object[] a) {
        return set.toArray(a);
    }
}
