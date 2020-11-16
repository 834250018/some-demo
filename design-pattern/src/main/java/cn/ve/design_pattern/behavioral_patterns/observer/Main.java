package cn.ve.design_pattern.behavioral_patterns.observer;

/**
 * 这里用一个模拟数据源表示被观察者,用一个展示牌表示观察者
 *
 * @author ve
 * @date 2020/5/2 17:38
 */
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        Display display = new Display(dataSource);
        // 数据源修改数据
        dataSource.setData("abc");
        // 数据源发布新消息通知观察者
        dataSource.notifyObserver();
        // 数据源修改数据
        dataSource.setData("ddbb");
        // 数据源发布新消息通知观察者
        dataSource.notifyObserver();
    }
}
