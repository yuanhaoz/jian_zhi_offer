package chapter_dp.behavior.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建 CareTaker 类。
 * @author yuanhao
 * @date 2018/6/14 21:14
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
