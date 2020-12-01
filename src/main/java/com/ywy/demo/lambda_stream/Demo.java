package com.ywy.demo.lambda_stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author ve
 * @date 2020/3/11 11:26
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {

        // 匿名内部类写法
        test(new Interf() {
            @Override
            public void lambda(String a, Integer b) {
                log.info("1");
            }
        });
        // lambda
        // 当且仅当参数为一个的时候,可以省略圆括号
        // 当且仅当代码块中仅有一行代码的时候,可以省略花括号
        test((a, b) -> log.info("i3"));

        test2();

        test3();
    }

    /**
     * eta-conversion
     * number -> String.valueOf(number) 可以写成 String::valueOf
     * Java 8的lambda支持这种eta-转换
     */
    private static void test3() {
        Comparator.comparing(User::getName);
        test4(a -> a); // a->a 重写了lambda(a){return a;}
        test4(String::toString);// a->a.toString()的eta写法
    }

    /**
     * extends与super用法区别
     */
    private static void test2() {
        // 上界
        ArrayList<? extends User> list = new ArrayList<User>() {{
            add(new User());
        }};
        // 可以使用
        list.get(0).userTest();
        list.get(0).peopleTest();
        //        list.get(0).gUserTest(); // 编译错误,父类不能使用子类方法
        // 不可以存任何类型
        //        list.add(new User());
        //        list.add(new People());
        //        list.add(new GeneralUser());

        // 下界
        ArrayList<? super User> list2 = new ArrayList<>();
        // 可以存子类,但是不确定会向上转成什么类型,可能是User,People,Object任意一种
        list2.add(new User());
        list2.add(new GeneralUser());
        //        list2.add(new People());// 编译错误,不能确定是哪种父类,所以不能添加父类
        // 编译错误
        //        list2.get(0).userTest();
        //        list2.get(0).peopleTest();
        //        list2.get(0).gUserTest();
    }

    public static void test(Interf interf) {
        // do nothing
        interf.lambda("1", 3);
    }

    public static void test4(Interf2 interf2) {
        // do nothing
        log.info(interf2.lambda("afasdjb"));
    }
}
