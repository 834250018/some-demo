package cn.ve.designpattern.behavioral_patterns.StrategyPattern.demo1;

/**
 * @author ve
 * @date 2020/5/1 20:50
 */
public class Customer {
    private CustomerTypeEnum type;

    public CustomerTypeEnum getType() {
        return type;
    }

    public void setType(CustomerTypeEnum type) {
        this.type = type;
    }
}
