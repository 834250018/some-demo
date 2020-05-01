package cn.ve.designpattern.behavioral_patterns.ChainOfResponsibilityPattern;

/**
 * 抽象血缘关系
 *
 * @author ve
 * @date 2019/9/19 16:09
 */
public abstract class MoneyResponsibility {

    // 此人的经济承担能力上限
    protected int moneyLimit;

    protected MoneyResponsibility nextRelationship;

    MoneyResponsibility(int moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public void setNextRelationship(MoneyResponsibility nextRelationship) {
        this.nextRelationship = nextRelationship;
    }

    public void cost(int money, String remark) {
        System.out.println(remark + "需要" + money + "元");
        if (money <= this.moneyLimit) { // 如果在能力之内,则自己掏钱
            takeMoney();
        } else { // 如果在能力之外,则由下一级责任链掏钱(如果有)
            noMoney();
            if (nextRelationship != null) {
                nextRelationship.cost(money, remark);
            }
        }
    }

    protected abstract void takeMoney();

    protected abstract void noMoney();

}
