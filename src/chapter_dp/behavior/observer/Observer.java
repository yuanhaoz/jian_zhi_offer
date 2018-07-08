package chapter_dp.behavior.observer;

/**
 * 创建 Observer 类。
 * @author yuanhao
 * @date 2018/6/16 19:45
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
