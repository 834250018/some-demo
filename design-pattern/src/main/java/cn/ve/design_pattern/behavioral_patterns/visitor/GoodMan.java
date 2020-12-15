package cn.ve.design_pattern.behavioral_patterns.visitor;


/**
 * 被访问者
 *
 * @author 83425
 * @date 2020/12/15
 */
public class GoodMan implements Interviewee {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
