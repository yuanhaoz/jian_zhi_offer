package chapter_dp.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建命令调用类。
 * @author yuanhao
 * @date 2018/6/10 14:32
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }

}
