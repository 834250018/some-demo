package cn.ve.design_pattern.behavioral_patterns.null_object;

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
