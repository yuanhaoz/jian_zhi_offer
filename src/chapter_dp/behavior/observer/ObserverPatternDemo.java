package chapter_dp.behavior.observer;

/**
 * 使用Subject和实体观察者对象。
 * @author yuanhao
 * @date 2018/6/16 19:52
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BianryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
