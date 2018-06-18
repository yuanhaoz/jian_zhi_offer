package chapter_dp.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建 subject 类。
 * @author yuanhao
 * @date 2018/6/16 19:44
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
