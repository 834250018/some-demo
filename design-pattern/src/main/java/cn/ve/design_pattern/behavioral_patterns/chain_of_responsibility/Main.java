package cn.ve.design_pattern.behavioral_patterns.chain_of_responsibility;

/**
 * 责任链模式
 * 老王有两个儿子
 * 一般情况下,都是大儿子出钱出力.但是偶尔老王有些开资大儿子无力承担,所以由小儿子出马
 *
 * @author ve
 * @date 2019/9/19 16:10
 */
public class Main {

    static MoneyResponsibility 初始化老王不花钱责任链() {
        MoneyResponsibility eldestSon = new EldestSon(5000);
        MoneyResponsibility youngestSon = new YoungestSon(500000000);

        // 一般都是小儿子出,小儿子顶不住了旧大儿子出钱
        eldestSon.setNextRelationship(youngestSon);
        // 所以形成了一条责任链,头部是大儿子
        return eldestSon;
    }

    public static void main(String[] args) {
        MoneyResponsibility 老王 = 初始化老王不花钱责任链();
        // 老王开始疯狂购物
        老王.cost(30, "老王想买条内裤");
        老王.cost(5, "老王想买条袜子");
        老王.cost(500, "老王想买条CK内裤");
        老王.cost(4000, "老王想买台ps5");
        老王.cost(100000, "老王兴奋过度住院了");

    }


}
