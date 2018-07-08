package chapter_dp.behavior.observer;

/**
 * 创建实体观察类。
 * @author yuanhao
 * @date 2018/6/16 19:49
 */
public class BianryObserver extends Observer {

    public BianryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
