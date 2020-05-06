package cn.ve.design_pattern.behavioral_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ve
 * @date 2020/5/2 17:33
 */
public class DataSource implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String data;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "data='" + data + '\'' +
                '}';
    }
}
