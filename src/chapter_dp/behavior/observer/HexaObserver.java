package chapter_dp.behavior.observer;

/**
 * 创建实体观察类。
 * @author yuanhao
 * @date 2018/6/16 19:49
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()));
    }
}
