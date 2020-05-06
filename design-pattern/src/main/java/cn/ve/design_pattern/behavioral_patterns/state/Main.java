package cn.ve.design_pattern.behavioral_patterns.state;

/**
 * 状态模式
 * 状态模式在行为上与策略模式类型,描述的是,不同的状态,执行不同的逻辑
 * 但状态模式着重于状态的切换,表示不同状态分别可以执行哪些逻辑,执行完了之后会变成其他哪种状态
 * 策略模式没有状态变更
 * 这里用穷人和富人的赚钱花钱,来阐述状态模式
 * 一共有四种行为(赚大钱,赚小钱,花光钱,花小钱),两种状态(穷,富)
 *
 * @author ve
 * @date 2020/5/2 12:45
 */
public class Main {
    public static void main(String[] args) {
        // 从前有一个穷书生
        AMan aMan = new AMan();
        // 他为了吃饭,每天都需要花一笔钱买米
        aMan.costLittleMoney(aMan);
        // 直到有一天他邂逅了邻居家的小妹妹,为了娶她,花光了所有的积蓄
        aMan.costAllMoney(aMan);
        // 但是他的积蓄不多,所以如花看不上他,于是他开始经商,并赚了一点小钱
        aMan.earnLittleMoney(aMan);
        // 如花终于嫁给了他,于是他开始存钱买房子
        aMan.earnLostOfMoney(aMan);
        // 最后他跟如花过上了没羞没臊的生活

        // 有钱人变穷人自行脑部
        aMan.earnLostOfMoney(aMan);
        aMan.earnLittleMoney(aMan);
        aMan.costLittleMoney(aMan);
        aMan.costAllMoney(aMan);
    }
}
