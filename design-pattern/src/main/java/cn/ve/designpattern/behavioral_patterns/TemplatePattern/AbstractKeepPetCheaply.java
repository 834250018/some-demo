package cn.ve.designpattern.behavioral_patterns.TemplatePattern;

/**
 * 平民养宠物
 *
 * @author ve
 * @date 2019/9/19 10:53
 */
public class AbstractKeepPetCheaply extends AbstractKeepPet {
    @Override
    public void selectPet() {
        System.out.println("我这么懒,养只猫吧");
    }

    @Override
    public void getPet() {
        System.out.println("没钱买品种猫,路边抓一只野猫");
    }

    @Override
    public void petNamed() {
        System.out.println("整天miaomiao叫的,就叫miumiu吧");
    }

    @Override
    public void feedPet() {
        System.out.println("巅峰猫粮太贵了,喂主食罐头也太贵了,还是喂皇家猫粮吧");
    }

    @Override
    public void wishPet() {
        System.out.println("宠物店洗澡要100大洋,我还是自己给他洗吧");
    }
}
