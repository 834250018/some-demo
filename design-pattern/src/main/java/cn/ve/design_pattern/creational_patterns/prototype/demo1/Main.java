package cn.ve.design_pattern.creational_patterns.prototype.demo1;

/**
 * 原型模式,通过初始化一个原型对象,快速创建一个有初始状态的克隆对象
 * 注意区分浅克隆(拷贝成员属性中对象的引用)与深克隆(对成员属性中对象进行创建及进一步拷贝)
 * 可以使用json序列化,反序列化实现对象的深克隆
 *
 * @author ve
 * @date 2020/4/30 22:00
 */
public class Main {
    public static void main(String[] args) {
        // 创建原型a
        User a = new User();
        a.setAge(18);
        a.setName("小明");
        // 快速克隆出一个新对象
        User b = (User)a.clone();
        System.out.println(a);
        System.out.println(b);
    }
}
