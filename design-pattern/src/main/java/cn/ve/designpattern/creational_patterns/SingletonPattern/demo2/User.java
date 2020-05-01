package cn.ve.designpattern.creational_patterns.SingletonPattern.demo2;

/**
 * 通过设置构造方法的做用域为private,然后返回一个静态对象
 *
 * @author ve
 * @date 2020/4/30 22:38
 */
public class User {

    private static User INSTANCE = new User();

    public User getInstance() {
        return INSTANCE;
    }
}
