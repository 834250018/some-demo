package cn.ve.designpattern.structural_patterns.DecoratorPattern;

/**
 * @author ve
 * @date 2020/5/2 18:55
 */
public class LOLPlayer implements Player {
    @Override
    public void play() {
        System.out.println("英雄联盟游戏中");
    }
}
