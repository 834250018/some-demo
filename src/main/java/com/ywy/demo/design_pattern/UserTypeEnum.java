package com.ywy.demo.design_pattern;

import com.ywy.demo.design_pattern.builder_pattern.User;

/**
 * 建造者模式BuilderPattern
 *
 * @author ve
 * @date 2019/6/19 15:34
 */
public enum UserTypeEnum {
    // 教师
    TEACHER {
        @Override
        public void exec(User user) {
            System.out.println(user.getName() + "在讲课");
        }
    },
    // 学生
    STUDENT {
        @Override
        public void exec(User user) {
            System.out.println(user.getName() + "在学习");
        }
    };

    public abstract void exec(User user);

}
