package cn.ve.design_pattern.structural_patterns.bridge.demo1;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class Sugar {
    private Integer count;

    public Sugar(Integer count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return count + "块糖";
    }
}
