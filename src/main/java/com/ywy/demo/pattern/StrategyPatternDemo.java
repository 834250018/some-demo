package com.ywy.demo.pattern;

import java.util.Arrays;

/**
 * @author ve
 * @date 2019/6/19 16:34
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        User teacher = new User();
        teacher.setAge(39);
        teacher.setName("王老师");
        teacher.setType(UserTypeEnum.TEACHER);
        User student = new User();
        student.setAge(18);
        student.setName("小明");
        student.setType(UserTypeEnum.STUDENT);
        // 策略模式,根据不同用户类型,执行不同的业务代码
        Arrays.asList(teacher, student).forEach(user -> user.getType().exec(user));

        // 工厂模式
        Animal cat = PetStore.getAnimal("cat");
        Animal dog = PetStore.getAnimal("dog");
    }
}
