package com.ywy.demo.other;

// 优化导入的类跟包 ctrl + alt + o

import com.ywy.demo.design_pattern.builder_pattern.User;

/**
 * intelliJ IDEA快捷键
 *
 * @author ve
 * @date 2019/7/11 14:57
 */
public class Shortcut {

    private String name;

    // ctrl + shift + u 选中并切换大小写
    public static final String ABCDEFG = "abcdefg";

    public static void main(String[] args) {
        User user = new User();

        // user.getAge().var + tab键快速生成变量
        int age = user.getAge();
        // 选中代码 ctrl + alt + t 快速生成if/try-catch/runnable/synchronized等代码
        synchronized (Shortcut.class) {
            System.out.println();
        }
        // ctrl + j 自动代码
        // sout
        // ctrl + 空格 代码提示
        for (int i = 0; i < 100; i++) {

        }
        // ctrl + alt + l 格式化代码

        // ctrl + p 方法参数提示, ctrl + q 当前方法的生命
//        Proxy.newProxyInstance();


    }
    // ctrl + o 重写方法
    // alt + insert生成代码(或右键Generate)
    /**
     * ctrl + shift + backspace 跳转到上次编辑的地方
     * ctrl +alt + 左/右 前后导航编辑过的地方
     * alt + f7 找到函数/类或变量的所有引用的地方
     * ctrl + shift + alt + n 查找类中的所有方法跟变量
     * 双击shift 在项目的所有目录查找文件
     * ctrl + n 查找类
     * ctrl + shift + n 查找文件
     * ctrl + g 定位行
     * ctrl + e 最近打开的文件
     * ctrl + w 选中,多次按会扩大选中范围
     * F2 错误/警告 快速定位
     * ctrl + b 快速打开光标处的类或方法
     * ctrl + alt + b 找所有的子类
     * ctrl + shift + 上/下 上下移动代码
     * ctrl + h 显示类结构图
     */

}
