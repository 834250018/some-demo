package cn.ve.design_pattern.behavioral_patterns.visitor;

/**
 * 访问者模式
 * 统一接口下,不同子类有不同逻辑,由访问者进行统一管理
 *
 * @author 83425
 * @date 2020/12/15
 */
public class Main {
    public static void main(String[] args) {

        // 死神来了
        Visitor death = new Visitor();
        Interviewee interviewee = new GoodMan();
        Interviewee interviewee1 = new BadGuy();

        interviewee.accept(death);
        interviewee1.accept(death);

//        death.visit(interviewee); // 编译错误,访问者需要知道被访问的人是好人还是坏人
//        death.visit(interviewee1); // 编译错误,访问者需要知道被访问的人是好人还是坏人
    }
}
