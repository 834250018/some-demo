package cn.ve.design_pattern.structural_patterns.decorator.demo1;

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
