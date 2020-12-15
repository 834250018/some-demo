package cn.ve.design_pattern.behavioral_patterns.visitor;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class Visitor {
    public void visit(BadGuy badGuy) {
        System.out.println("bad guy pass out");
    }

    public void visit(GoodMan goodMan) {
        System.out.println("good people survive");
    }
}
