package cn.ve.design_pattern.behavioral_patterns.null_object;

/**
 * @author ve
 * @date 2020/5/2 10:52
 */
public class Main {
    public static void main(String[] args) {
        BookFactory.getBook(1).show();
        BookFactory.getBook(-1).show(); // 这里返回的是空对象而不是null,所以可以执行show方法,虽然不会打印任何内容
    }
}
