package chapter_dp.behavior.observer;

/**
 * 创建实体观察类。
 * @author yuanhao
 * @date 2018/6/16 19:49
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
