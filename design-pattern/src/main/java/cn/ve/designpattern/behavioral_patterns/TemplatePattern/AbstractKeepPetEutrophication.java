package cn.ve.designpattern.behavioral_patterns.TemplatePattern;

/**
 * 平民养宠物
 *
 * @author ve
 * @date 2019/9/19 10:53
 */
public class AbstractKeepPetEutrophication extends AbstractKeepPet {
    @Override
    public void selectPet() {
        System.out.println("我这么高大威武英俊帅气,肯定要养只陨石边牧啦!");
    }

    @Override
    public void getPet() {
        System.out.println("国内认证的宠物店里面买吧,两万块带血统证书的");
    }

    @Override
    public void petNamed() {
        System.out.println("这么威武,就叫你'老大'");
    }

    @Override
    public void feedPet() {
        System.out.println("狗粮买最贵,什么贵买什么,营养膏,维生素都要.");
    }

    @Override
    public void wishPet() {
        System.out.println("宠物店开个年费洗浴套餐.");
    }
}
