package cn.ve.designpattern.behavioral_patterns.ObserverPattern;

/**
 * @author ve
 * @date 2020/5/2 17:28
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
