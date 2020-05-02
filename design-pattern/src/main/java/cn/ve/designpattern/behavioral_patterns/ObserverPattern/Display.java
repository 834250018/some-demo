package cn.ve.designpattern.behavioral_patterns.ObserverPattern;

/**
 * @author ve
 * @date 2020/5/2 17:35
 */
public class Display implements Observer {

    private Subject subject;

    public Display(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("收到订阅消息");
        System.out.println("拉取最新数据: " + subject);
    }
}
