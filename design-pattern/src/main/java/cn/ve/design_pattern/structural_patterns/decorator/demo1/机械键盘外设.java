package cn.ve.design_pattern.structural_patterns.decorator.demo1;

/**
 * @author ve
 * @date 2020/5/2 18:56
 */
public class 机械键盘外设 implements Player {

    private Player player;

    public 机械键盘外设(Player player) {
        System.out.println("接入机械键盘");
        this.player = player;
    }

    void playFast() {
        System.out.println("放技能更快!");
    }

    @Override
    public void play() {
        this.player.play();
    }
}
