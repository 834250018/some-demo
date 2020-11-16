package cn.ve.design_pattern.behavioral_patterns.command;

/**
 * 命令模式
 *
 * @author ve
 * @date 2020/5/2 18:04
 */
public class Main {
    public static void main(String[] args) {
        Jiding l = new Jiding();
        Kourou m = new Kourou();
        Waiter waiter = new Waiter();
        waiter.setL(l);
        waiter.setM(m);

        waiter.getL();// 点菜辣子鸡丁
    }
}
