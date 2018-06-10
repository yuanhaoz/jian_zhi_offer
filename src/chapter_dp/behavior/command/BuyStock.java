package chapter_dp.behavior.command;

/**
 * 创建实现了 Order 接口的实体类。
 * @author yuanhao
 * @date 2018/6/10 14:30
 */
public class BuyStock implements Order {

    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }

}
