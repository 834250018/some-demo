package cn.ve.design_pattern.structural_patterns.bridge.demo1;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class Ice {
    private Integer count;

    public Ice(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return count + "块冰";
    }
}
