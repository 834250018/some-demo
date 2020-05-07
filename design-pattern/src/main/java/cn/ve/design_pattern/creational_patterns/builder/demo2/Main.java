package cn.ve.design_pattern.creational_patterns.builder.demo2;

/**
 * 假如User必须参数是年龄跟姓名,可选参数是备注,户籍,现住址
 * 重叠构造器(当参数很多的时候,要写很多构造方法,假如使用了最长的构造方法,但是中间两个参数传反过来了,很难发现问题)
 * public User(Integer age, String name)
 * public User(Integer age, String name, String remark)
 * public User(Integer age, String name, String remark, String hometown)
 * public User(Integer age, String name, String remark, String hometown, String address)
 * public User(Integer age, String name, String remark, String hometown, String address, String 其他...)
 * <p>
 * java bean模式(当必填参数很多的时候,少了某一个必选参数,很难排查)
 * User user = new User();
 * user.setAge();
 * user.setName();
 * user.setRemark();
 * <p>
 * 最佳方式,使用混合构造器(建造者模式)
 *
 * @author ve
 * @date 2020/5/7
 */
public class Main {
    public static void main(String[] args) {
        User user =
                new User.UserBuilder(20, "小强") // 两个必选参数
                        .address("广州") // 三个可选参数
                        .remark("美男子")
                        .hometown("澳大利亚")
                        .build();
    }
}
