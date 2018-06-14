package chapter_dp.behavior.memento;

/**
 * 创建 Originator 类。
 * @author yuanhao
 * @date 2018/6/14 21:11
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

}
