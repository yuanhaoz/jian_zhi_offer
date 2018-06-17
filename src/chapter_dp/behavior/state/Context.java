package chapter_dp.behavior.state;

/**
 * 创建 Context 类。
 * Created by 18710 on 2018/6/17.
 */
public class Context {

    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
