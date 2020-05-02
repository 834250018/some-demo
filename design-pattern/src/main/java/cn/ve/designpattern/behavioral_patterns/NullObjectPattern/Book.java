package cn.ve.designpattern.behavioral_patterns.NullObjectPattern;

/**
 * @author ve
 * @date 2020/5/2 10:53
 */
public class Book implements IBook {
    @Override
    public void show() {
        System.out.println("a book");
    }
}
