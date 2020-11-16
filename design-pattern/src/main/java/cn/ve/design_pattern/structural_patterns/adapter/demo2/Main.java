package cn.ve.design_pattern.structural_patterns.adapter.demo2;

/**
 * 比如"注册"这个接口,在初始的业务,只需要账号密码即可
 * 现在在不改变原有数据入口的基础上,注册的时候增加默认的其他信息
 *
 * @author ve
 * @date 2020/5/1 14:03
 */
public class Main {
    public static void main(String[] args) {
        // 旧版本,只需要用户名跟密码
        new IUser() {
            @Override public void registry(String username, String password) {
                // save db
                System.out.println("保存数据: " + username + ":" + password);
            }
        }.registry("123", "123"); // 对于用户来说,注册只需要填账号密码

        // 适配旧接口,增加新的字段并设置默认值
        new AbstractUserAdaptor() {
            @Override void newRegistry(String username, String password, String address, Integer age, Integer sex) {
                // save db,实际创建用户的业务已经通过适配器调整,但对用户透明
                System.out.println("保存数据: " + username + ":" + password + ":" + address + ":" + age + ":" + sex);
            }
        }.registry("123", "123"); // 对于用户来说,注册还是只需要填账号密码
    }
}
