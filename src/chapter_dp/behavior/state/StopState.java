package chapter_dp.behavior.state;

/**
 * 创建实现接口的实体类。
 * Created by 18710 on 2018/6/17.
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player in the stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State.";
    }

}
