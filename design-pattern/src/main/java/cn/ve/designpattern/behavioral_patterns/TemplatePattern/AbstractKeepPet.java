package cn.ve.designpattern.behavioral_patterns.TemplatePattern;

/**
 * 模板模式
 * 如养宠物,过程是一样的,从选择宠物品种到获取宠物,取名,喂食,洗澡,
 * 整个过程是固定的,但是不同的人,每一个步骤,具体操作不一样
 * 比如路人甲,获取宠物是靠领养,路人乙获取宠物是靠花钱购买
 *
 * @author ve
 * @date 2019/9/19 10:46
 */
public abstract class AbstractKeepPet {

    /**
     * 选择宠物种类
     */
    public abstract void selectPet();

    /**
     * 获取宠物
     */
    public abstract void getPet();

    /**
     * 给宠物取名
     */
    public abstract void petNamed();

    /**
     * 喂宠物
     */
    public abstract void feedPet();

    /**
     * 为宠物清洁
     */
    public abstract void wishPet();

    /**
     * 养宠物的过程是确定的,但是实际操作因人而异
     */
    public final void keepPet() {
        selectPet();
        getPet();
        petNamed();
        feedPet();
        wishPet();
    }
}
