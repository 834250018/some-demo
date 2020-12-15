package cn.ve.design_pattern.creational_patterns.singleton.demo3;


/**
 * 懒汉单例
 *
 * @author 83425
 * @date 2020/12/15
 */
public class User {
    private static User INSTANCE;

    public User getInstance() {
        if (INSTANCE == null) {
            synchronized (User.class) {
                if (INSTANCE == null) {
                    INSTANCE = new User();
                }
            }
        }
        return INSTANCE;
    }

    private User() {

    }
}
