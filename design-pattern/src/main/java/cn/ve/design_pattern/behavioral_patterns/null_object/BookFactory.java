package cn.ve.design_pattern.behavioral_patterns.null_object;

/**
 * @author ve
 * @date 2020/5/2 10:55
 */
public enum BookFactory {
    ;

    public static IBook getBook(int i) {
        switch (i) {
            case 1:
                return new Book();
            default:
                return new NullObject();
        }
    }
}
