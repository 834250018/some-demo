package cn.ve.design_pattern.behavioral_patterns.visitor;


/**
 * 被访问者
 *
 * @author 83425
 * @date 2020/12/15
 */
public interface Interviewee {

    void accept(Visitor visitor);
}
