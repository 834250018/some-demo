package cn.ve.design_pattern.structural_patterns.bridge.demo1;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class Milktea {
    private Ice ice;
    private Sugar sugar;

    public void sale() {
        System.out.println("" + sugar + ice + "的奶茶被卖出");
    }

    public Milktea(Ice ice, Sugar sugar) {
        this.ice = ice;
        this.sugar = sugar;
    }
}
