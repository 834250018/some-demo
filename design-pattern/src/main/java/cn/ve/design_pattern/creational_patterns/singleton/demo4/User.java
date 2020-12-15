package cn.ve.design_pattern.creational_patterns.singleton.demo4;


/**
 * 内部静态类单例(懒加载)
 *
 * @author 83425
 * @date 2020/12/15
 */
public class User {

    static class SingletonHolder {
        private static User INSTANCE = new User();
    }

    public User getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private User() {

    }
}
