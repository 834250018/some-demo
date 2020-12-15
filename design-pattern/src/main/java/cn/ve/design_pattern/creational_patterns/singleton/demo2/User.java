package cn.ve.design_pattern.creational_patterns.singleton.demo2;

/**
 * 饿汉单例
 *
 * @author ve
 * @date 2020/4/30 22:38
 */
public class User {

    private static User INSTANCE = new User();

    public User getInstance() {
        return INSTANCE;
    }

    private User() {

    }
}
