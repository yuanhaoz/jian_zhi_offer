package chapter_dp.behavior.memento;

/**
 * 创建 Memento 类。
 * @author yuanhao
 * @date 2018/6/14 21:10
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
