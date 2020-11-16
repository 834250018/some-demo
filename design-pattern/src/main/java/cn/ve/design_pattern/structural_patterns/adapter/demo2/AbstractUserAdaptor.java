package cn.ve.design_pattern.structural_patterns.adapter.demo2;

/**
 * 快速注册适配器,只需要提供用户名跟密码即可注册,其他都可以使用默认值
 * 这里我是按我的理解写的,不一定正确,有需要可以去看springMVC中的AbstractHandlerMethodAdapter
 *
 * @author ve
 * @date 2020/5/1 14:05
 */
public abstract class AbstractUserAdaptor implements IUser {
    @Override public void registry(String username, String password) {
        newRegistry(username, password, "默认地址", 18, 0);
    }

    abstract void newRegistry(String username, String password, String address, Integer age, Integer sex);
}
