package cn.ve.design_pattern.behavioral_patterns.strategy.demo1;

/**
 * @author ve
 * @date 2020/5/1 20:50
 */
public enum CustomerTypeEnum {
    RICH{
        @Override
        void market() {
            System.out.println("给有钱人邮寄会员卡");
        }
    },
    POOR{
        @Override
        void market() {
            System.out.println("给普通用户发送邮件促销活动信息");
        }
    };
    abstract void market();
}
